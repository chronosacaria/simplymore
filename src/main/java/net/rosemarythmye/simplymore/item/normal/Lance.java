package net.rosemarythmye.simplymore.item.normal;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.ShieldDecorationRecipe;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.rosemarythmye.simplymore.effect.ModEffects;

public class Lance extends Sword {

    public Lance(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, String... repairIngredient) {
        super(toolMaterial, attackDamage, attackSpeed, settings);

        this.repairIngredient = repairIngredient;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity.getVehicle() instanceof LivingEntity
                && selected
                && ((PlayerEntity) entity)
                    .getStackInHand(Hand.OFF_HAND).getItem().getAttributeModifiers(EquipmentSlot.MAINHAND)
                        .get(EntityAttributes.GENERIC_ATTACK_DAMAGE).isEmpty()) ((PlayerEntity) entity)
                            .addStatusEffect(new StatusEffectInstance(ModEffects.LANCE,9999999,0));
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}