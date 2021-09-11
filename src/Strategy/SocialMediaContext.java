package Strategy;

public class SocialMediaContext {
    ISocialMediaStrategy smStrategy;

    //smStrategy passed as a parameter on the runtime
    //Note the input parameter type is an Interface
    public void setSocialmediaStrategy(ISocialMediaStrategy smStrategy)
    {
        this.smStrategy = smStrategy;
    }

    public void connect(String name)
    {
        smStrategy.connectTo(name);
    }
}
