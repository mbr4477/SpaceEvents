# SpaceEvents

## Overview
This application uses NASA's (unofficial) Deep Space Network API to periodically
check for new DSN connections. New connection events are pushed out to your
personal PushBullet account via the PushBullet API. The design seeks to pursue
principles of Clean Architecture and allow for easy extension and changing of
the technologies and libraries used. For example, changing this com.matthewrussell.spaceevents.usecases.app to tweet
updates instead of using PushBullet would be as simple as writing a new
`ISpaceEventPublisher` implementation.

Before running, create a `pushbullet.properties` file in `src/main/resources/`
with your PushBullet API key:

```
API_KEY=x.XXXXXXXXXXXXX
```
