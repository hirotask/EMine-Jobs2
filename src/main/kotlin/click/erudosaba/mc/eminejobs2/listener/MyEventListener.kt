package click.erudosaba.mc.eminejobs2.listener

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.*
import click.erudosaba.mc.eminejobs2.jobs.Job
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class MyEventListener(val plugin : Main) : Listener {

    @EventHandler
    fun OnWoodBreak(e: WoodBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "woodcutter") {
                val job = Job(plugin,"woodcutter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onStoneBreak(e: StoneBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "miner") {
                val job = Job(plugin,"miner")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onDirtBreak(e: DirtBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "digger") {
                val job = Job(plugin,"digger")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onSlashMob(e: SlashMobEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "swordman") {
                val job = Job(plugin,"swordman")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onSlashMob(e: BowMobEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "archer") {
                val job = Job(plugin,"archer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onFarm(e: PlayerFarmEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "farmer") {
                val job = Job(plugin,"farmer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onExplore(e: ExploreEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "explorer") {
                val job = Job(plugin,"explorer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onSmelt(e: SmeltEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "smelter") {
                val job = Job(plugin,"smelter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onFish(e: FishEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "fisherman") {
                val job = Job(plugin,"fisherman")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onCraft(e: CraftEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "crafter") {
                val job = Job(plugin,"crafter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onEnchant(e: EnchantEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "enchanter") {
                val job = Job(plugin,"enchanter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onForge(e: ForgeEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "weaponsmith") {
                val job = Job(plugin,"weaponsmith")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onBrew(e: BrewEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "brewer") {
                val job = Job(plugin,"brewer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onBuild(e: BuildEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "builder") {
                val job = Job(plugin,"builder")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onGunCreate(e: GunCreateEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "gunner") {
                val job = Job(plugin,"gunner")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onEat(e: EatEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "hunger") {
                val job = Job(plugin,"hunger")
                jobplayer.exp += job.JobExp
            }
        }
    }
}