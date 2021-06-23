package click.erudosaba.mc.eminejobs2.listener

import click.erudosaba.mc.eminejobs2.Main
import click.erudosaba.mc.eminejobs2.event.*
import click.erudosaba.mc.eminejobs2.jobs.Jobs
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class MyEventListener(val plugin : Main) : Listener {

    @EventHandler
    fun OnWoodBreak(e: WoodBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.WOODCUTTER) {
                val job = Jobs.WOODCUTTER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onStoneBreak(e: StoneBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.MINER) {
                val job = Jobs.MINER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onDirtBreak(e: DirtBreakEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.DIGGER) {
                val job = Jobs.DIGGER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onSlashMob(e: SlashMobEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.SWORDMAN) {
                val job = Jobs.SWORDMAN
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onSlashMob(e: BowMobEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.ARCHER) {
                val job = Jobs.ARCHER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onFarm(e: PlayerFarmEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.FARMER) {
                val job = Jobs.FARMER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onExplore(e: ExploreEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.EXPLORER) {
                val job = Jobs.EXPLORER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onSmelt(e: SmeltEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.SMELTER) {
                val job = Jobs.SMELTER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onFish(e: FishEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.FISHERMAN) {
                val job = Jobs.FISHERMAN
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onCraft(e: CraftEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.CRAFTER) {
                val job = Jobs.CRAFTER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onEnchant(e: EnchantEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.ENCHANTER) {
                val job = Jobs.ENCHANTER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onForge(e: ForgeEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.WEAPONSMITH) {
                val job = Jobs.WEAPONSMITH
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onBrew(e: BrewEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.BREWER) {
                val job = Jobs.BREWER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onBuild(e: BuildEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.BUILDER) {
                val job = Jobs.BUILDER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onGunCreate(e: GunCreateEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.GUNNER) {
                val job = Jobs.GUNNER
                jobplayer.exp += job.jobExp
            }
        }
    }

    @EventHandler
    fun onEat(e: EatEvent) {
        val jobplayer = e.player

        if(jobplayer.hasJob()) {
            if(jobplayer.JobID == Jobs.HUNGER) {
                val job = Jobs.HUNGER
                jobplayer.exp += job.jobExp
            }
        }
    }
}