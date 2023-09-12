package jimenezli.neuro21.item;

import jimenezli.neuro21.ModEntityTypes;
import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UpgradeChipItem extends Item {
    public UpgradeChipItem() {
        super(ItemHandler.defaultBuilder());
    }

    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (livingEntity.getClass() == Turtle.class) {
            if (!player.level.isClientSide && livingEntity.isAlive()) {
                ((Turtle) livingEntity).convertTo(ModEntityTypes.getVedalEntity(), true);
                itemStack.shrink(1);
            }
            return InteractionResult.sidedSuccess(player.level.isClientSide);
        } else if (livingEntity.getClass() == Fox.class) {
            if (!player.level.isClientSide && livingEntity.isAlive()) {
                ((Fox) livingEntity).convertTo(ModEntityTypes.getAnnyEntity(), true);
                itemStack.shrink(1);
            }
            return InteractionResult.sidedSuccess(player.level.isClientSide);
        } else if (livingEntity.getClass() == Cow.class) {
            if (!player.level.isClientSide && livingEntity.isAlive()) {
                ((Cow) livingEntity).convertTo(ModEntityTypes.getIronCowEntity(), true);
                itemStack.shrink(1);
            }
            return InteractionResult.sidedSuccess(player.level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("item.neuro21.upgrade_chip.description"));
    }
}