package com.daversini.cavesandcliffs.items;

import com.daversini.cavesandcliffs.CavesAndCliffs;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(CavesAndCliffs.TAB));
    }
}