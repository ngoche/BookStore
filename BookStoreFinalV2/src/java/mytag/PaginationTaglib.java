/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytag;

import java.io.Writer;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTaglib extends SimpleTagSupport {

    private String uri;
    private int offset;
    private int count;
    private int max;
    private int steps;
    private String previous = "Previous";
    private String next = "Next";

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag *
     * processing, body iteration, etc.
     */
    private Writer getWriter() {
        JspWriter out = getJspContext().getOut();
        return out;
    }

    @Override
    public void doTag() throws JspException {
        Writer out = getWriter();
        try {
            out.write("<nav>");
            out.write("<ul class=\"pagination\">");

            if (offset < steps) {
                out.write(constructLink(1, previous, "disabled", true));
            } else {
                out.write(constructLink(offset - steps, previous, null, false));
            }

            for (int itr = 0; itr < count; itr += steps) {
                if (offset == itr) {
                    out.write(constructLink((itr / max + 1) - 1 * steps, String.valueOf(itr / max + 1), "active", true));
                } else {
                    out.write(constructLink(itr / max * steps, String.valueOf(itr / max + 1), null, false));
                }
            }

            if (offset + steps >= count) {
                out.write(constructLink(offset + steps, next, "disabled", true));
            } else {
                out.write(constructLink(offset + steps, next, null, false));
            }

            out.write("</ul>");
            out.write("</nav>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Paginator tag", ex);
        }
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getUri() {
        return uri;
    }

    public int getOffset() {
        return offset;
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }

    public String getPrevious() {
        return previous;
    }

    public String getNext() {
        return next;
    }

    public int getSteps() {
        return steps;
    }

    private String constructLink(int page, String text, String className, boolean disabled) {
        StringBuilder link = new StringBuilder("<li");
        if (className != null) {
            link.append(" class=\"");
            link.append(className);
            link.append("\"");
        }
        if (disabled) {
            link.append(">").append("<a href=\"#\">" + text + "</a></li>");
        } else {
            link.append(">").append("<a href=\"" + uri + "?offset=" + page + "\">" + text + "</a></li>");
        }
        return link.toString();
    }

}
