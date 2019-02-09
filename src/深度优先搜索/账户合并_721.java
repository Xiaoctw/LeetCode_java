package 深度优先搜索;

import org.junit.Test;

import java.util.*;

@SuppressWarnings("ALL")
public class 账户合并_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<String>> res = new HashMap();
        HashMap<String, String> map = new HashMap<>();
        for (List<String> account : accounts) {
            map.put(account.get(0), "");
            for (int i = 1; i < account.size(); i++) {
                if (map.containsKey(account.get(i))) {
                    map.put(account.get(0), map.get(account.get(i)));
                }
                map.put(account.get(i), account.get(0));
            }
        }
        for (String s : map.keySet()) {
            String pre = find(map, s);
            if (!res.containsKey(pre)) {
                res.put(pre, new ArrayList<>());
            }
            res.get(pre).add(s);
        }
        return new ArrayList<>(res.values());
    }

    private String find(HashMap<String, String> map, String s) {
        String res = s;
        while (!map.get(res).equals("")) {
            res = map.get(res);
        }
        return res;
    }


}
