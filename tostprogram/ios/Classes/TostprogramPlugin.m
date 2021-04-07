#import "TostprogramPlugin.h"
#if __has_include(<tostprogram/tostprogram-Swift.h>)
#import <tostprogram/tostprogram-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "tostprogram-Swift.h"
#endif

@implementation TostprogramPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftTostprogramPlugin registerWithRegistrar:registrar];
}
@end
