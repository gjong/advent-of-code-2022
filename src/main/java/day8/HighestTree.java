package day8;

class HighestTree {

    private HighestTree leftTree;
    private HighestTree rightTree;
    private HighestTree aboveTree;
    private HighestTree belowTree;

    private int left;
    private int viewToLeft = 0;
    private int right;
    private int viewToRight = 0;
    private int top;
    private int viewToTop = 0;
    private int bottom;
    private int viewToBottom = 0;

    private int value;

    HighestTree(int value) {
        left = value;
        top = value;
        bottom = value;
        right = value;
        this.value = value;
    }

    public HighestTree(HighestTree left, HighestTree above, int value) {
        this.value = value;
        this.left = Math.max(left.value, left.left);
        this.top = Math.max(above.value, above.top);

        leftTree = left;
        aboveTree = above;
        viewToLeft = 1;
        viewToTop = 1;
        if (leftTree.value < value) {
            var nextLeft = left.leftTree;
            while (nextLeft != null) {
                viewToLeft++;
                if (value <= nextLeft.value) break;
                nextLeft = nextLeft.leftTree;
            }
        }
        if (aboveTree.value < value) {
            var nextAbove = aboveTree.aboveTree;
            while (nextAbove != null) {
                viewToTop++;
                if (value <= nextAbove.value) break;
                nextAbove = nextAbove.aboveTree;
            }
        }
    }

    void correct(HighestTree right, HighestTree below) {
        this.right = Math.max(right.value, right.right);
        this.bottom = Math.max(below.value, below.bottom);
        this.belowTree = below;
        this.rightTree = right;

        viewToBottom = 1;
        viewToRight = 1;
        if (leftTree.value < value) {
            var nextRight = right.rightTree;
            while (nextRight != null) {
                viewToRight++;
                if (value <= nextRight.value) break;
                nextRight = nextRight.rightTree;
            }
        }
        if (belowTree.value < value) {
            var nextBelow = belowTree.belowTree;
            while (nextBelow != null) {
                viewToBottom++;
                if (value <= nextBelow.value) break;
                nextBelow = nextBelow.belowTree;
            }
        }
    }

    boolean isHighest() {
        return value > right
                || value > left
                || value > top
                || value > bottom;
    }

    int scenicScore() {
        return viewToRight * viewToLeft * viewToTop * viewToBottom;
    }
}
