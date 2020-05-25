/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

/**
 *
 */
public class ApplicationContext {
    private ApplicationSettings applicationSettings;
    private ApplicationContext applicationContext;
    private ApplicationContext() {
        applicationSettings = new ApplicationSettings();
    }

    // Singleton
    public static ApplicationContext instance = new ApplicationContext();
    public static ApplicationContext getInstance() {
        return instance;
    }

    public ApplicationSettings getApplicationSettings() {
        return applicationSettings;
    }
    public void setApplicationSettings(ApplicationSettings applicationSettings) {
        this.applicationSettings = applicationSettings;
    }
}
