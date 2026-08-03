# Culinary Dragons

A polished food-and-drink expansion for Minecraft 1.18.2 Forge modpacks such as Guns, Magic and Dragons.

## v0.3.3 machine grounding update

- Added full-footprint base plates to all four machine models so the block below cannot show through the machine footprint.
- Added bottom-face culling to station geometry.
- Disabled ambient occlusion on station models to prevent dark seams and block-edge shading artifacts on stepped geometry.
- Retained directional placement, rotation, block loot tables, complete station textures, and the v0.3.2 item asset fix.

## v0.3.6 unique original item art

- Reworked the complete food-and-drink texture set using original 16x16 pixel art.
- Public Farmer's Delight and Let's Do Vinery imagery was used only to study readable category conventions; no upstream assets were copied.
- Fruits now use recognizable silhouettes: apples, bananas, cherries, grape clusters, berries, strawberries, pineapple, kiwi, papaya, dragonfruit, mango, and peach.
- Juices use tall glass-bottle silhouettes.
- Smoothies use wide lidded cups with foam and straw/garnish details.
- Wine uses tall dark bottles with labels and wax/cork closures.
- Ciders and mead use shorter rounded bottles.
- Tea and hot chocolate use handled mugs with steam.
- Fruit salad, stew, punch, and prepared meals use bowls or plated-food silhouettes.


- Farmer's Delight 1.18.2-1.2.3 is an optional dependency.
- Juicer accepts `farmersdelight:tomato` and `farmersdelight:onion`.
- Blender accepts Farmer's Delight tomato, cabbage, and onion.
- Fermentation Barrel accepts Farmer's Delight melon juice.
- Compatibility recipes are conditionally loaded only when Farmer's Delight is installed.


- Juicer: fruit → juice
- Blender: fruit → smoothies
- Fermentation Barrel: juice/fruit → wines, ciders, and mead
- Cooking Pot: raw ingredients → prepared meals

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
