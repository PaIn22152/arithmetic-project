package com.payne.leetCode.daily;

import java.util.HashSet;
import java.util.Set;

public class D_679 {
    /**
     * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [4, 1, 8, 7]
     * 输出: True
     * 解释: (8-4) * (7-1) = 24
     * 示例 2:
     * <p>
     * 输入: [1, 2, 1, 2]
     * 输出: False
     * 注意:
     * <p>
     * 1。除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
     * 2。每个运算符对两个数进行运算。
     * 特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，
     * 表达式 -1 - 1 - 1 - 1 是不允许的。
     * 3。你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/24-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean judgePoint24(int[] nums) {

        Set<Integer> set = new HashSet<>();
        Set<String> history = new HashSet<>();
        for (int a = 0; a < 4; a++) {
            set.add(a);
            for (int b = 0; b < 4; b++) {
                if (!set.contains(b)) {
                    set.add(b);
                    for (int c = 0; c < 4; c++) {
                        if (!set.contains(c)) {
                            set.add(c);
                            for (int d = 0; d < 4; d++) {
                                if (!set.contains(d)) {
                                    if (check(nums[a], nums[b], nums[c], nums[d], history)) {
                                        return true;
                                    }
                                }
                            }
                            set.remove(c);
                        }

                    }
                    set.remove(b);
                }
            }
            set.remove(a);
        }

        return false;

    }

    private boolean check(int a, int b, int c, int d, Set<String> history) {
        if (history.contains(a + "-" + b + "-" + c + "-" + d)) {
            return false;
        }
        for (int i = 0; i < 6; i++) {
            float ab;
            switch (i) {
                default:
                case 0:
                    ab = (float) a + (float) b;
                    break;
                case 1:
                    ab = (float) a - (float) b;
                    break;
                case 2:
                    ab = (float) a * (float) b;
                    break;
                case 3:
                    ab = (float) a / (float) b;
                    break;
                case 4:
                    ab = (float) b - (float) a;
                    break;
                case 5:
                    ab = (float) b / (float) a;
            }

            for (int j = 0; j < 6; j++) {
                float abc;
                switch (j) {
                    default:
                    case 0:
                        abc = (float) ab + (float) c;
                        break;
                    case 1:
                        abc = (float) ab - (float) c;
                        break;
                    case 2:
                        abc = (float) ab * (float) c;
                        break;
                    case 3:
                        abc = (float) ab / (float) c;
                        break;
                    case 4:
                        abc = (float) c - (float) ab;
                        break;
                    case 5:
                        abc = (float) c / (float) a;
                }

                for (int k = 0; k < 6; k++) {
                    switch (k) {
                        default:
                        case 0:
                            if ((abc + (float) d) - 24 == 0) {
                                return true;
                            }
                            break;
                        case 1:
                            if ((abc - (float) d) - 24 == 0) {
                                return true;
                            }
                            break;
                        case 2:
                            if ((abc * (float) d) - 24 == 0) {
                                return true;
                            }
                            break;
                        case 3:
                            if ((abc / (float) d) - 24 == 0) {
                                return true;
                            }
                            break;
                        case 4:
                            if (((float) d / abc) - 24 == 0) {
                                return true;
                            }
                            break;
                        case 5:
                            if (((float) d - abc) - 24 == 0) {
                                return true;
                            }
                            break;
                    }
                }
            }

        }

        float ab = 0;
        for (int i = 0; i < 6; i++) {
            switch (i) {
                default:
                case 0:
                    ab = (float) a + (float) b;
                    break;
                case 1:
                    ab = (float) a - (float) b;
                    break;
                case 2:
                    ab = (float) a * (float) b;
                    break;
                case 3:
                    ab = (float) a / (float) b;
                    break;
                case 4:
                    ab = (float) b - (float) a;
                    break;
                case 5:
                    ab = (float) b / (float) a;
                    break;
            }
        }

        float cd = 0;
        for (int i = 0; i < 6; i++) {
            switch (i) {
                default:
                case 0:
                    cd = (float) c + (float) d;
                    break;
                case 1:
                    cd = (float) c - (float) d;
                    break;
                case 2:
                    cd = (float) c * (float) d;
                    break;
                case 3:
                    cd = (float) c / (float) d;
                    break;
                case 4:
                    cd = (float) d - (float) c;
                    break;
                case 5:
                    cd = (float) d / (float) c;
                    break;
            }
        }

        for (int i = 0; i < 4; i++) {
            switch (i) {
                default:
                case 0:
                    if ((ab + cd) - 24 == 0) {
                        return true;
                    }
                    break;
                case 1:
                    if ((ab - cd) - 24 == 0) {
                        return true;
                    }
                    break;
                case 2:
                    if ((ab * cd) - 24 == 0) {
                        return true;
                    }
                    break;
                case 3:
                    if ((ab / cd) - 24 == 0) {
                        return true;
                    }
                    break;
                case 4:
                    if ((cd - ab) - 24 == 0) {
                        return true;
                    }
                    break;
                case 5:
                    if ((cd / ab) - 24 == 0) {
                        return true;
                    }
                    break;

            }

        }
        history.add(a + "-" + b + "-" + c + "-" + d);
        return false;
    }

}
