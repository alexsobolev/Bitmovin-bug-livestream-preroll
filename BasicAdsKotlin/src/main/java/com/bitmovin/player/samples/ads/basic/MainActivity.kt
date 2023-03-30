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

private const val AD_SOURCE_1 = "https://pubads.g.doubleclick.net/gampad/ads?sz=640x480&iu=/124319096/external/single_ad_samples&ciu_szs=300x250&impl=s&gdfp_req=1&env=vp&output=vast&unviewed_position_start=1&cust_params=deployment%3Ddevsite%26sample_ct%3Dskippablelinear&correlator="

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
            player?.load(SourceConfig.fromUrl("https://devstreaming-cdn.apple.com/videos/streaming/examples/bipbop_adv_example_hevc/master.m3u8"))
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
