package com.example.tostprogram;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.widget.Toast;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** TostprogramPlugin */
public class TostprogramPlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  ///
  /// when the Flutter Engine is detached from the Activity
  private  final  MethodChannel channel;
  private Activity activity;
 
  

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "tostprogram");
    
    channel.setMethodCallHandler(new TostprogramPlugin(flutterPluginBinding.activity(),channel));
  }
  
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "tostprogram");
    channel.setMethodCallHandler(new TostprogramPlugin(registrar.activity(),channel));
  }
  
  private TostprogramPlugin(Activity activity, MethodChannel channel){
    this.activity = activity;
    this.channel = channel;
    this.channel.setMethodCallHandler(this);
  }



  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } 
    else if(call.method.equals("showToast")){
      // String msg = call.argument("msg").toString();
      Toast.makeText(activity,"hi i am flutter ",Toast.LENGTH_LONG).show();
    }
       
    else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
