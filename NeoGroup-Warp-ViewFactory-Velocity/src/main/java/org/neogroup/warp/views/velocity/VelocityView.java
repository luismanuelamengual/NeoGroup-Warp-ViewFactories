
package org.neogroup.warp.views.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.neogroup.warp.views.View;

import java.io.StringWriter;

/**
 * Velocity view
 */
public class VelocityView extends View {

    private static String TEMPLATE_PROCESSING_ERROR = "Error processing velocity template !!";

    private final Template template;
    private final VelocityContext context;

    /**
     * Constructor for the velocity view
     * @param template velocity template
     */
    public VelocityView(Template template) {
        this.template = template;
        this.context = new VelocityContext();
    }

    /**
     * Set a parameter to the view
     * @param name name of parameter
     * @param value value of parameter
     */
    @Override
    public void setParameter(String name, Object value) {
        context.put(name, value);
    }

    /**
     * Get a view parameter
     * @param name name of parameter
     * @return value of parameter
     */
    @Override
    public Object getParameter(String name) {
        return context.get(name);
    }

    /**
     * Renders the view to a string
     * @return string
     */
    @Override
    public String render() {
        String response = null;
        try (StringWriter writer = new StringWriter()) {
            template.merge(context, writer);
            response = writer.toString();
        }
        catch (Throwable throwable) {
            throw new RuntimeException(TEMPLATE_PROCESSING_ERROR, throwable);
        }
        return response;
    }
}
