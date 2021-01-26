package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import org.bukkit.ChatColor.*
import org.bukkit.entity.Player

class Help(plugin: Main) : SubCommand() {
    override fun onCommand(player: Player, args: Array<String>) {
        val array = arrayOf(
                "${DARK_AQUA}/emj stats ${WHITE}→ ${DARK_GREEN}現在の自分の就いている職業，レベルが確認できる"
                ,"${DARK_AQUA}/emj join ${GOLD}[job] ${WHITE}→ ${DARK_GREEN}指定した職業に就ける"
                ,"${DARK_AQUA}/emj leave ${WHITE}→ ${DARK_GREEN}現在就いている職業を辞める(レベルはリセット)"
                ,"${DARK_AQUA}/emj browse ${WHITE}→ ${DARK_GREEN}現在就くことが出来る職業一覧を表示する"
                ,"${DARK_AQUA}/emj info ${GOLD}[job] ${WHITE}→ ${DARK_GREEN}職業に関する情報を表示"
                ,"${DARK_AQUA}/emj admininfo ${GOLD}[playername] ${WHITE}→ ${DARK_GREEN}指定プレーヤーのステータスを表示"
                ,"${DARK_AQUA}/emj fire ${GOLD}[playername] ${WHITE}→ ${DARK_GREEN}指定プレイヤーを職業から解雇"
                ,"${DARK_AQUA}/emj employ ${GOLD}[playername] [job] ${WHITE}→ ${DARK_GREEN}指定したプレイヤーを指定した職業に就かせる"
                ,"${DARK_AQUA}/emj promote ${GOLD}[playername] [levels] ${WHITE}→ ${DARK_GREEN}指定プレーヤーの職業のLvを上げる"
                ,"${DARK_AQUA}/emj demote ${GOLD}[playername] [levels] ${WHITE}→ ${DARK_GREEN}指定プレーヤーの職業のLvをさげる"
                ,"${DARK_AQUA}/emj grantexp ${GOLD}[playername] [experience] ${WHITE}→ ${DARK_GREEN}指定したプレーヤーに経験値を付与"
                ,"${DARK_AQUA}/emj removeexp ${GOLD}[playername] [experience] ${WHITE}→ ${DARK_GREEN}指定プレーヤーの経験値を下げる"
                ,"${DARK_AQUA}/emj transfer ${GOLD}[playername] [newjob] ${WHITE}→ ${DARK_GREEN}レベルと経験値を保持した状態で転職させる"
                ,"${DARK_AQUA}/emj reload ${WHITE}→ プラグインをリロードする"

        )

        if(player.hasPermission("emj.admin")) {
            for(message in array) player.sendMessage(message)
        } else {
            for(x in 0..4) player.sendMessage(array[x])
        }
    }

    override fun name(): String {
        return "help"
    }

    override fun info(): String {
        return ""
    }

    override fun aliases(): Array<String> {
        return arrayOf(String())
    }
}