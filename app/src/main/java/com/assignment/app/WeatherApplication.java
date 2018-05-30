package com.assignment.app;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.assignment.app.di.components.DaggerMainComponent;
import com.assignment.app.di.components.MainComponent;
import com.assignment.app.di.modules.MainModule;

public class WeatherApplication extends Application {

  private MainComponent mainComponent;

  @Override public void onCreate() {
    super.onCreate();
    initializeInjector();
    Fresco.initialize(this);
  }

  private void initializeInjector() {
    mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
  }

  public MainComponent getMainComponent() {
    return mainComponent;
  }
}
