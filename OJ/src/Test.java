import java.util.ArrayList;
import java.util.List;

public class Test{
    public ArrayList<ArrayList<String>> suggestedProducts (List<String> products, String searchWord) {
        // write code here
        List<List<String>> ret = new ArrayList<>();
        
        for(int i = 1; i<searchWord.length()+1; i++){
            String temp = searchWord.substring(0,i);
            List<String> list = new ArrayList<String>();
            int n = 0;
            for(int j = 0; j < products.size(); j++){
                if(products.get(j).indexOf(temp)==0 && n++<3){
                    list.add(products.get(j));
                }
            }
            ret.add(list);
        }
        return (ArrayList)ret;
    }

    public static void main(String[] args) {
        ArrayList<String> products = new ArrayList<>();
        products.add("lexin");
        products.add("lexingsd");
        products.add("lesfds");
        products.add("lexfsad");
        products.add("leogh");
        String searchWord = "lexin";
        Test test = new Test();
        test.suggestedProducts(products,searchWord);
    }
}