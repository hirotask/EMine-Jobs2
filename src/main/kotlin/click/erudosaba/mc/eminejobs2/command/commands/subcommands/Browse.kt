package click.erudosaba.mc.eminejobs2.command.commands.subcommands

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.command.commands.SubCommand
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.entity.Player

class Browse(plugin: Main) : SubCommand() {
    //TODO
    /*
    タイトル：現在就くことが出来る職業
    表示内容：
    レベルが２０以下→すべての職業のアイコンを表示（マウスカーソルを合わせると職業名を表示させる）
    Jobs.values()→職業一覧表示
    ２０より大きい→何も表示しない
     */
    override fun onCommand(player: Player, args: Array<String>) {
        TODO("Not yet implemented")

    }

    override fun name(): String {
        TODO("Not yet implemented")
    }

    override fun info(): String {
        TODO("Not yet implemented")
    }

    override fun aliases(): Array<String> {
        TODO("Not yet implemented")
    }

}
