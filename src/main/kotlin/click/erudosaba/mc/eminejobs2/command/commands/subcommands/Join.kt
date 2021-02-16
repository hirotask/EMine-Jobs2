package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Join(val plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        if(args.isEmpty()) {
            player.sendMessage("${ChatColor.BOLD}引数を指定してください")
            return
        }

        if(!plugin.sqlUtil.isExists(player)) {
            plugin.sqlUtil.insert(player,args[0])
            player.sendMessage("あなたは${ChatColor.YELLOW}${args[0]}に就きました")
        } else {
            if(plugin.sqlUtil.getLevel(player) <= 20) {
                plugin.sqlUtil.delete(player)
                plugin.sqlUtil.insert(player,args[0])
                player.sendMessage("あなたはレベルをリセットし，${ChatColor.YELLOW}${args[0]}に転職しました")
            } else {
                player.sendMessage("あなたはレベルが20以上のため転職できません")
                return
            }
        }
    }

    override fun name(): String {
        return "join"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }

}
