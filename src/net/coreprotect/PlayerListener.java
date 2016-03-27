package net.coreprotect;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerListener implements Listener {

    public static Map<String, String> messages = Collections.synchronizedMap(new HashMap<String, String>());

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat (AsyncPlayerChatEvent event){
        String message = event.getMessage();
        if (message.startsWith("/")) {
            return;
        }

        String uuid = event.getPlayer().getUniqueId().toString();
        if (message.startsWith("s/")) {
            String[] split = message.split("/");
            if (split.length >= 3) {
                String oldString = split[1];
                String newString = split[2];

                if (messages.get(uuid) != null) {
                    final Player player = event.getPlayer();
                    final String newMessage = messages.get(uuid).replace(oldString, "§o" + newString + "§r");
                    Corrector.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Corrector.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            try {
                                player.chat(newMessage);
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 1);

                }

                return;
            }
        }

        messages.put(uuid, message);
    }

}
