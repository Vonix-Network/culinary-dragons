# Culinary Dragons

Cooking, drinks, smoothies, wine, and fantasy food for **Minecraft 1.18.2 Forge** modpacks such as Guns, Magic and Dragons.

## Features

- Juicer: grapes, berries, and apples into juice
- Blender: apple, berry, and melon smoothies
- Fermentation Barrel: wine, cider, and berry mead
- Cooking Pot: meat platters, baked potato platters, and vegetable stew
- Additional drinks: mint tea, hot chocolate, dragonfire punch, and dragonfruit cider
- Server-authoritative station interactions
- Crafting recipes, item models, block models, blockstates, and translations

Stations consume a supported ingredient held in the active hand and return the result to the player inventory. If the inventory is full, the result is safely dropped at the player.

## Requirements

- Minecraft Java Edition 1.18.2
- Minecraft Forge 40.2.0 or newer in the 40.x line
- Java 17

This is a Forge-only mod and has no required third-party mod dependency.

## Build

```bash
./gradlew clean build
```

The distributable JAR is written to `build/libs/`.

## Current scope

The processing stations currently perform immediate server-side interaction processing rather than using a timed GUI. A future release can add container menus, progress bars, fluid containers, configurable effects, and aging stages.

## License

MIT. Minecraft and Forge are not owned by this project.
