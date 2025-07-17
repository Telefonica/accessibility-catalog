When performing a code review, pay special attention to **potential breaking changes** in the public API of the library.

**Identify and flag prominently:**
- Removal of public classes, interfaces, methods, or properties.
- Changes in method signatures (e.g., removal or reordering of parameters, changes in parameter types, changes in return types to a less specific type).
- Changes in visibility of public members to a less accessible scope (e.g., public to protected/private).
- Removal of public enum values.

If a breaking change is detected, comment on its potential impact on existing consumers of the library and suggest if a migration guide might be necessary.