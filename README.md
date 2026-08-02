# Culinary Dragons

A polished food-and-drink expansion for Minecraft 1.18.2 Forge modpacks such as Guns, Magic and Dragons.

## v0.3.0 visual and station overhaul

- Replaced the old placeholder cube stations with modeled station silhouettes:
  - Juicer with hopper/nozzle detail
  - Blender with base, glass vessel, and lid
  - Fermentation Barrel with bands and bung detail
  - Cooking Pot with rim, body, and feet
- Added directional placement and blockstate rotation for every station.
- Added proper block loot tables so stations drop themselves when mined.
- Added dedicated face textures for all station models.
- Kept all fruit, juice, smoothie, wine, cider, and mead content from v0.2.0.
- Processing remains server-authoritative and supports the fruit chains already documented below.

## Station workflow

- **Juicer:** fruit → juice
- **Blender:** fruit → smoothies
- **Fermentation Barrel:** juice/fruit → wines, ciders, and mead
- **Cooking Pot:** raw ingredients → prepared meals

## Requirements

- Minecraft Java Edition 1.18.2
- Minecraft Forge 40.2.0 or newer in the 40.x line
- Java 17

Forge-only. No third-party mod is required.

## Build

```bash
./gradlew clean build
```

The JAR is written to `build/libs/`.
