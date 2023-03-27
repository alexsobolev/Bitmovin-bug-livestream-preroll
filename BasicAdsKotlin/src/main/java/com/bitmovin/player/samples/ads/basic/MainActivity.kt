package com.bitmovin.player.samples.ads.basic

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bitmovin.player.PlayerView
import com.bitmovin.player.api.Player
import com.bitmovin.player.api.PlayerConfig
import com.bitmovin.player.api.advertising.AdItem
import com.bitmovin.player.api.advertising.AdSource
import com.bitmovin.player.api.advertising.AdSourceType
import com.bitmovin.player.api.advertising.AdvertisingConfig
import com.bitmovin.player.api.source.SourceConfig
import com.bitmovin.player.samples.ads.basic.databinding.ActivityMainBinding

private const val AD_SOURCE_1 =
    "https://ib.adnxs.com/ptv?member=7823&publisher=1000494&inv_code=bild.de-app_android_phone-video_video-pre&vwidth=&vheight=&vplaybackmethod=3&kw_vidContentId=50277754&kw_misc=Virale Videos,Zoo,Flusspferd,Lebensmittel,viral,Tierbabys&appid=com.netbiscuits.bild.android&aaid=c36c2611-bdbd-4531-9392-09b5810f3ee8&size=1x1&pt0=68807&pt1=video&pt2=app.bild.de&pt3=app.bild&LimitAdTrackingEnabled=false&test=1&kw_test=nativeapp&kw_aboLevel=1&gdpr=1&gdpr_consent=CPiiZAAPiiZAAFZABCDECqCgAP_AAEgAAAYgIcpZ_T7VbWFCef59aPsgOYxXVMCWAuQCCASAA2ABgAKQcDwCkmAaNESgBgACAQAAoRJBIAIEDAEECUAAYAAEAAGgAAAEhAAIIABAgBEAAAIYAAoCAAAAAACIgAAREAAAmRgYA8bmGEAAxAAQYAAQgAAAAAAAAgMAAAAAAAIAAAAAAAgAAAAAAAIIcoBmSLVTUFA6ehJKAAACIAQVAAQACAACACAAiAAgAAQYAwAAEAaAECAAAAAAAAAgBABAAAAAAAEAEAAIAAEAACgAAAAAAAAAABAgBEAAAAQAAgCAIAAAAAAAAAAAAAAgBAQAAJCGAAAAAAQAAAEgAABAAAAAAEAAAAAAAAAAAAAAAAAAAAAAAICIyAKAEMAJgBHAF5gM8GAAgCxAHVEQBwBDAD8AOqAkQBOwCkQGTiAAIAJAoB8AAIACgARQAnACgAFQALAAdgA9ACEAEcAKQAVwBogDVAHGAQiAkwCTgE0AJ2AX4A9AB-wD-gJLAS0Av4BjIDHAGnANrAdUGgFABcAEMAPwAgoB1QEiAJ2AUiAycBngYAEAdQBTYqAMAEMAJgAXACOALzAZ4KABAEFAOqOgaAALAAqABkADgAIAAZAA0AB4AD6AIYAigBMACeAFWALgAugBiADeAHMAPwAhgBEACWAEwAKMAUoAsQBbgDDAGiAPaAfgB-gEWgI4AjoBKQCxAFzALqAYoA3ABxADqAHoAReAkQBOwChwF5gL6AYMAycBlgDVQIcjgC0ADgAPAAuACQAHIAPwAoADNAILAQcBCACIgF6AMCAZkA14B0gDqgJWAU2ArsBkIDJgG0EICgACwAMgBDACYAFUALgAYgA3gClAFiARwAlIBcwDFAHUAPQAkQBk4DPAGqkAAoAzQCCgFiAMyAdUlAaAAWABkADgAPAAiABMACqAFwAMQAhgBEACjAFKALcAfgBHAC6gGKANwAdQBF4CRAF5gMnAZYAzwkAIAAuADkAZoBBwDMgGvAOqAlYpAoAAWABUADIAHAAQAAyABoADyAIYAigBMACeAFIAKoAYgA5gB-AEMAIgAUYApQBYgC3AGjAPwA_QCLQEcAR0AlIBcwDFAG4APQAi8BIgCdgFDgLzAX0AycBlgDPCgBAAC4AJAAcgA_ADaAM0Ag4BJwCxAF1ANeAdUBTYCuwGTAOCAAAA.YAAAAAAAAAAA&kw_gdpr_applies=0"

class MainActivity : AppCompatActivity() {
    private lateinit var playerView: PlayerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create AdSources
        val firstAdSource = AdSource(AdSourceType.Ima, AD_SOURCE_1)

        // Set up a pre-roll ad
        val preRoll = AdItem("pre", firstAdSource)

        // Add the AdItems to the AdvertisingConfig
        val advertisingConfig = AdvertisingConfig(preRoll)

        // Create a new PlayerConfig containing the advertising config. Ads in the AdvertisingConfig will be scheduled automatically.
        val playerConfig = PlayerConfig(advertisingConfig = advertisingConfig)

        // Create new PlayerView with our PlayerConfig
        playerView = PlayerView(this, Player.create(this, playerConfig)).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
            )
            player?.load(SourceConfig.fromUrl("https://bild.personalstream.tv/v1/master.m3u8?devtype=tv&ads.country=de&ads.uid=bildde&ads.pf=bildtv&ads.cpid=bild"))
        }

        // Add PlayerView to the layout
        binding.root.addView(playerView, 0)
    }

    override fun onStart() {
        super.onStart()
        playerView.onStart()
    }

    override fun onResume() {
        super.onResume()
        playerView.onResume()
    }

    override fun onPause() {
        playerView.onPause()
        super.onPause()
    }

    override fun onStop() {
        playerView.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        playerView.onDestroy()
        super.onDestroy()
    }
}
