package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AccountsMerge
 * @Description TODO
 * @Author katefu
 * @Date 9/28/23 10:45 PM
 * @Version 1.0
 **/
public class AccountsMerge {
    public static void main(String[] args) {
        List<String> account1 = new ArrayList<>();
        account1.add("Alex");
        account1.add("Alex5@m.co");
        account1.add("Alex4@m.co");
        account1.add("Alex0@m.co");

        List<String> account2 = new ArrayList<>();
        account2.add("Ethan");
        account2.add("Ethan3@m.co");
        account2.add("Ethan3@m.co");
        account2.add("Ethan0@m.co");

        List<String> account3 = new ArrayList<>();
        account3.add("Kevin");
        account3.add("Kevin4@m.co");
        account3.add("Kevin2@m.co");
        account3.add("Kevin2@m.co");

        List<String> account4 = new ArrayList<>();
        account4.add("Gabe");
        account4.add("Gabe0@m.co");
        account4.add("Gabe3@m.co");
        account4.add("Gabe2@m.co");

        List<String> account5 = new ArrayList<>();
        account5.add("Gabe");
        account5.add("Gabe3@m.co");
        account5.add("Gabe4@m.co");
        account5.add("Gabe2@m.co");


        List<List<String>> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);

        Solution721 test = new Solution721();
        List<List<String>> res = test.accountsMerge(accounts);
        System.out.println(res);

    }
}

class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, List<String>> nameToEmails = new HashMap<>();
        HashMap<String, Integer> nameFreq = new HashMap<>();

        for(List<String> account: accounts){
            String name = account.get(0);
            String anotherName = "";
            boolean shouldMerge = false;
            for(int i=1; i<account.size(); i++){
                String email = account.get(i);
                if(emailToName.containsKey(email)){
                    // find this email exist in previous account name
                    // entire account shoule be merged
                    anotherName = emailToName.get(email);
                    if(!anotherName.replaceAll("[0-9]", "").equals(name)){
                        shouldMerge = true;
                        break;
                    }
                }else{
                    emailToName.put(email, name+nameFreq.getOrDefault(name, 0));
                }
            }

            if(shouldMerge){
                String newName = anotherName+nameFreq.getOrDefault(anotherName, 0);
                if(!nameToEmails.containsKey(anotherName)){
                    nameToEmails.put(newName, new ArrayList<>());
                }
                for(int i=1; i<account.size(); i++){
                    if(!nameToEmails.get(newName).contains(account.get(i))){
                        nameToEmails.get(newName).add(account.get(i));
                    }
                }
            }else{
                account.remove(0);
                String newName = name+nameFreq.getOrDefault(name, 0);
                nameToEmails.put(newName, new ArrayList<>());
                for(int i=1; i<account.size(); i++){
                    if(!nameToEmails.get(newName).contains(account.get(i))){
                        nameToEmails.get(newName).add(account.get(i));
                    }
                }
                nameFreq.put(name, nameFreq.getOrDefault(name,0)+1);
            }
        }

        for(Map.Entry<String, List<String>> entry: nameToEmails.entrySet()){
            List<String> newAccount = new ArrayList<>();
            newAccount.add(entry.getKey().replaceAll("[0-9]",""));
            newAccount.addAll(entry.getValue());
            res.add(newAccount);
        }

        return res;
    }
}