package view;

public class HtmlGenerator {

    public static String getMessagePage(String message, String url){
        StringBuilder ret = new StringBuilder("");
        ret.append("<html>");
        ret.append("<head>");
        ret.append("<meta charset=\"UTF-8\">");
        ret.append("<title>提示界面</title>");
        ret.append("</head>");
        ret.append("<body>");
        ret.append("<h3>"+message+"</h3>");
        ret.append(String.format("<a href = \"%s\"> 请点击跳转 </a>",url));
        ret.append("</body>");
        ret.append("</html>");
        System.out.println(ret.toString());
        return ret.toString();
    }
}
