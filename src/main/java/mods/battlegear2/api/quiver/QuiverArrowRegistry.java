package mods.battlegear2.api.quiver;

import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class QuiverArrowRegistry {

    private static Map<ItemStack,  Class<? extends EntityArrow>> map = new TreeMap<ItemStack,  Class<? extends EntityArrow>>(new StackComparator());

    public static void addArrowToRegistry(Item itemId, int itemMetadata, Class<? extends EntityArrow> entityArrow){
        ItemStack stack = new ItemStack(itemId, 1, itemMetadata);
        addArrowToRegistry(stack, entityArrow);
    }
    
    public static void addArrowToRegistry(ItemStack stack, Class<? extends EntityArrow> entityArrow){
        ItemStack st = stack.copy();
        st.stackSize = 1;
        map.put(st, entityArrow);
    }

    public static Class<? extends EntityArrow> getArrowClass(ItemStack stack){
        return map.get(stack);
    }

    static class StackComparator implements Comparator<ItemStack> {
        @Override
        public int compare(ItemStack stack, ItemStack stack2) {
            if(stack == stack2){
                return 0;
            }else{

                boolean idDiff = stack.getItem() == stack2.getItem();
                if(idDiff != false){
                    return -1;
                }else{
                	return -1;
                }
            }

        }
    }


}
