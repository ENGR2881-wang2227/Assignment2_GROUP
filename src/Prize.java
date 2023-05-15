public class Prize {
    private String name;
    private String template;
    private String topicsRequired;

    public Prize (String name, String template, String topicsRequired) {
        this.name = name;
        this.template = template;
        this.topicsRequired = topicsRequired;
    }

    public String getName() {
        return name;
    }

    public String getTemplate() {
        return template;
    }

    public String getTopicsRequired() {
        return topicsRequired;
    }

    public String show(){
        String s = "Name: " + name + " Template: " + template + " Topics Required: " + topicsRequired + "\n";
        return s;
    }
}
