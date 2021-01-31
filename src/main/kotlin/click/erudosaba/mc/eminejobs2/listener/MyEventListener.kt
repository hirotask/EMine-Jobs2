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
            if(jobplayer.jobName == "WoodCutter") {
                val job = JobManager(plugin,"Miner")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onStoneBreak(e: StoneBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Miner") {
                val job = JobManager(plugin,"Miner")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onDirtBreak(e: DirtBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Digger") {
                val job = JobManager(plugin,"Digger")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onSlashMob(e: SlashMobEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "SwordMan") {
                val job = JobManager(plugin,"SwordMan")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onSlashMob(e: BowMobEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Archer") {
                val job = JobManager(plugin,"Archer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onFarm(e: PlayerFarmEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Farmer") {
                val job = JobManager(plugin,"Farmer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onExplore(e: ExploreEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Explorer") {
                val job = JobManager(plugin,"Explorer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onSmelt(e: SmeltEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Smelter") {
                val job = JobManager(plugin,"Smelter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onFish(e: FishEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Fisherman") {
                val job = JobManager(plugin,"Fisherman")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onCraft(e: CraftEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Crafter") {
                val job = JobManager(plugin,"Crafter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onEnchant(e: EnchantEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Enchanter") {
                val job = JobManager(plugin,"Enchanter")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onForge(e: ForgeEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "WeaponSmith") {
                val job = JobManager(plugin,"WeaponSmith")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onBrew(e: BrewEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Brewer") {
                val job = JobManager(plugin,"Brewer")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onBuild(e: BuildEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Builder") {
                val job = JobManager(plugin,"Builder")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onGunCreate(e: GunCreateEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Gunner") {
                val job = JobManager(plugin,"Gunner")
                jobplayer.exp += job.JobExp
            }
        }
    }

    @EventHandler
    fun onEat(e: EatEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.jobName == "Hunger") {
                val job = JobManager(plugin,"Hunger")
                jobplayer.exp += job.JobExp
            }
        }
    }
}