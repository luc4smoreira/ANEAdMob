

del /f/q/s %ANDROID_OUTPUT_PATH%\res

rmdir /q/s %ANDROID_OUTPUT_PATH%\res

del /f/q/s %ANDROID_OUTPUT_PATH%\temp

mkdir %ANDROID_OUTPUT_PATH%\temp

mkdir %ANDROID_CODE_PATH%\outputs\aar\temp

%SEVEN_ZIP% x %ANDROID_CODE_PATH%\outputs\aar\*.aar -o%ANDROID_CODE_PATH%\outputs\aar\temp -y

copy %ANDROID_CODE_PATH%\outputs\aar\temp\*.jar %ANDROID_OUTPUT_PATH%\temp
copy %ANDROID_CODE_PATH%\outputs\aar\temp\libs\*.jar %ANDROID_OUTPUT_PATH%\temp

del %ANDROID_OUTPUT_PATH%\temp\FlashRuntimeExtensions.jar

%SEVEN_ZIP% x %ANDROID_OUTPUT_PATH%\temp\*.jar -o%ANDROID_OUTPUT_PATH%\temp -y

xcopy %ANDROID_CODE_PATH%\outputs\aar\temp\res %ANDROID_OUTPUT_PATH%\res\ /e

del %ANDROID_OUTPUT_PATH%\temp\*.jar

del %ANDROID_OUTPUT_PATH%\*.jar

cd %ANDROID_OUTPUT_PATH%\temp

echo off

echo Remove folders inside %ANDROID_OUTPUT_PATH%\res\ with unsuported languages (*-lan) 

pause

echo on

%SEVEN_ZIP% a ..\libAdMob.jar *

cd ..\..\..\..\batch

del /f/q/s %ANDROID_OUTPUT_PATH%\temp

rmdir /q/s %ANDROID_OUTPUT_PATH%\temp

del /f/q/s %ANDROID_CODE_PATH%\outputs\aar\temp

rmdir /q/s %ANDROID_CODE_PATH%\outputs\aar\temp

