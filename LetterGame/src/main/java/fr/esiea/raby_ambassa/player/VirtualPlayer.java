package fr.esiea.raby_ambassa.player;

/**
 * Created by Zenika on 03/03/2017.
 */
public class VirtualPlayer extends Player{

    public VirtualPlayer(int id) {
        super("Virtual Player "+id);
    }

//    public String canPlay(CommonPot commonPot, WordList wordList) {
//
//
//        return watchForNewWord(commonPot.getCommonPot());
//    }

//    private String watchForNewWord(ArrayList<Character> commonPot) {
//        String root;
//        ArrayList<Character> ch = new ArrayList<Character>();
//        ArrayList<Character> h = new ArrayList<Character>();
//        ArrayList<Character> result = new ArrayList<Character>();
//        LinkedList<String> ret = new LinkedList<String>();
//        int a;
//        for(int i = 0; i < commonPot.size(); i++) {
//            root = commonPot.get(i).toString();
//            if (ret.indexOf(root) >= 0) {
//            } else {
//                ret.add(root);
//                h.clear();
//                h.addAll(commonPot);
//                try {
//                    h.remove(i);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage() + commonPot.size());
//                }
//                a = result.size();
//                ch = watchForNewWord(h);
//                result.addAll(ch);
//                for (int j = a; j < result.size(); j++) {
//                    result.set(j, root + result.get(j));
//                }
//            }
//        }
//
//        return "";
//    }

}
