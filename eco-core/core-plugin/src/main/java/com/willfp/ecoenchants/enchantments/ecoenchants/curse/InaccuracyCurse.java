package com.willfp.ecoenchants.enchantments.ecoenchants.curse;

import com.willfp.eco.util.NumberUtils;
import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

public class InaccuracyCurse extends EcoEnchant {
    public InaccuracyCurse() {
        super(
                "inaccuracy_curse", EnchantmentType.CURSE
        );
    }

    // START OF LISTENERS


    @Override
    public void onBowShoot(LivingEntity shooter, Arrow arrow, int level, EntityShootBowEvent event) {
        double spread = this.getConfig().getDouble(EcoEnchants.CONFIG_LOCATION + "spread");

        Vector velocity = event.getProjectile().getVelocity().clone();

        velocity.add(new Vector(NumberUtils.randFloat(-spread, spread), NumberUtils.randFloat(-spread, spread), NumberUtils.randFloat(-spread, spread)));
        event.getProjectile().setVelocity(velocity);
    }
}
