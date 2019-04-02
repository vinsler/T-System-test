package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Logic {

    public boolean actions(List x, List y) {
        if (x.isEmpty() & y != null) {
            return true;
        }

        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).equals(x.get(0))) {
                if (findXfromPosition(x, y.subList(i, y.size() - 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findXfromPosition(List x, List y) {
        int sum = 0;
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).equals(x.get(sum))) {
                sum++;
            }
        }
        if (sum == x.size()) {
            return true;
        }
        return false;
    }
}
