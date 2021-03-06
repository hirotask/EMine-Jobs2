package click.erudosaba.mc.eminejobs2.listener

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.*
import click.erudosaba.mc.eminejobs2.jobs.JobManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class MyEventListener(val plugin : Main) : Listener {

    @EventHandler
    fun OnWoodBreak(e: WoodBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "woodcutter") {
                val job = JobManager(plugin,"woodcutter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onStoneBreak(e: StoneBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "miner") {
                val job = JobManager(plugin,"miner")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onDirtBreak(e: DirtBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "digger") {
                val job = JobManager(plugin,"digger")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onSlashMob(e: SlashMobEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "swordman") {
                val job = JobManager(plugin,"swordman")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onSlashMob(e: BowMobEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "archer") {
                val job = JobManager(plugin,"archer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onFarm(e: PlayerFarmEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "farmer") {
                val job = JobManager(plugin,"farmer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onExplore(e: ExploreEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "explorer") {
                val job = JobManager(plugin,"explorer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onSmelt(e: SmeltEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "smelter") {
                val job = JobManager(plugin,"smelter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onFish(e: FishEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "fisherman") {
                val job = JobManager(plugin,"fisherman")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onCraft(e: CraftEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "crafter") {
                val job = JobManager(plugin,"crafter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onEnchant(e: EnchantEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "enchanter") {
                val job = JobManager(plugin,"enchanter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onForge(e: ForgeEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "weaponsmith") {
                val job = JobManager(plugin,"weaponsmith")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onBrew(e: BrewEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "brewer") {
                val job = JobManager(plugin,"brewer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onBuild(e: BuildEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "builder") {
                val job = JobManager(plugin,"builder")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onGunCreate(e: GunCreateEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "gunner") {
                val job = JobManager(plugin,"gunner")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onEat(e: EatEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "hunger") {
                val job = JobManager(plugin,"hunger")
                jobplayer.exp += job.JobExp
            }
        }
    }
}