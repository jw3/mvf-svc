MVF Services
===

Some simple services to simple things...

### Configuration

- `LOG_LEVEL`:
- `ACTOR_LOG_LEVEL`:

- `SERVICE_HOST`:
- `SERVICE_PORT`:

### Reference

- https://github.com/jw3/mvf


### OpenShift

Example:
- `#! oc new-app jwiii/sbt-s2i:0.13.16-2.12.3~https://github.com/jw3/mvf-svc.git --build-env="SBT_SUBPROJECT=client" --name=test`
