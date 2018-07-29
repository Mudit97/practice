

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegularExpression
 */
@WebServlet("/RegularExpression")
public class RegularExpression extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegularExpression() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
    		throws IOException {
    	res.setContentType("text/html");
    	PrintWriter pw = res.getWriter();
    	String pat=req.getParameter("pattern");
    	String str=req.getParameter("string");
    	try {	
	    	Pattern pattern = Pattern.compile(pat);
	    	if(str.isEmpty()) {
	    		pw.println("Empty String");
	    	}
	    	else if(pat.isEmpty()) {
	    		pw.print("Empty Pattern");
	    	}
	    	else {
		    	Matcher matcher = pattern.matcher(str);
		    	System.out.println(matcher.matches());
		    	String s = Boolean.toString(matcher.matches());
		    	pw.write(s);
		    	while (matcher.find()) {
		            for (int i = 1; i <= matcher.groupCount(); i++) {
		                pw.println("matched text: "+ matcher.group(i));
		                pw.println("match start: "+matcher.start(i));
		                pw.println("match end: "+matcher.end(i));
		            }
		        }
	    	}
    	}catch(PatternSyntaxException exception) {
    		pw.write("Pattern syntax not ok");
    		System.out.println(exception);
    	}
    }
    	
}
