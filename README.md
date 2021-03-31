# Hello Angular Addon
Simple Addon showcasing an Angular app behind nginx proxy 

### Summary
I did have some hard time to create a custom Homeassistant addon web-ui using a the new ingress functionality introduced with HA.
In particular, the problem lied on the ingress uri path to rewrite. 

Thanks to the help received by @pvizeli, I was able to fix the issue. This repo was born as issue showcase, but it has now been updated with
rewrite logic to make it work as expected. Therefore, I'll leave this repo available to eveyron who needs some sort of easy example to start
with.

### Ok, but what was the problem?
Simply put, the problem was to correctly map the relative paths to the angular app. 
The ingress logic of HA does "generate" an _addon_uri_ randomly and the angular app should be able to change its base-path accordingly.

At the time of writing, the generated ingress uri path is in the following form `/api/hassio_ingress/<some_token>/`. The `<some_token>` part is randomly generated.
At boot time, the addon should configure the angular app so that such path is "prepended" to the angular app routing. 

To do so, there are two possible approaches
1. Implement the relative path within angular (e.g. change the base-path) and, at boot time, implement some sort of SED/REPLACE system to change the base-href parameters.
1. Rely on nginx rewrite

In this repository I've implemented the second option (That allows me to be consistent at development time when implementing the app on local machine).


