## Live Streaming and Preroll Advertisement Bug Reproduction App for Bitmovin Player on Android

This app is based on the [Bitmovin Player Android Samples repository](https://github.com/bitmovin/bitmovin-player-android-samples) and is designed to reproduce a specific bug that occurs when attempting to play live streaming and preroll advertisement content encoded with different codecs.

The bug is device-specific and has been observed on the following devices:

- Pixel 4a5g with Android 13
- Pixel 6a with Android 14
- Galaxy A5 with Android 6.0.1

This app provides a simple and easy-to-use interface for reproducing the bug and collecting relevant information for debugging and resolving the issue.


```
2023-03-27 15:37:04.933 14857-14881 MediaCodecVideoRenderer com...ovin.player.samples.ads.basic  E  Video codec error
                                                                                                      android.media.MediaCodec$CodecException: Error 0x80000000
2023-03-27 15:37:04.942 14857-14881 ExoPlayerImplInternal   com...ovin.player.samples.ads.basic  E  Playback error
                                                                                                      com.google.android.exoplayer2.ExoPlaybackException: MediaCodecVideoRenderer error, index=0, format=Format(1, null, null, video/avc, avc1.4D4020, 1128168, null, [640, 360, 25.0], [-1, -1]), format_supported=YES
                                                                                                          at com.google.android.exoplayer2.ExoPlayerImplInternal.handleMessage(ExoPlayerImplInternal.java:576)
                                                                                                          at android.os.Handler.dispatchMessage(Handler.java:102)
                                                                                                          at android.os.Looper.loopOnce(Looper.java:201)
                                                                                                          at android.os.Looper.loop(Looper.java:288)
                                                                                                          at android.os.HandlerThread.run(HandlerThread.java:67)
                                                                                                      Caused by: com.google.android.exoplayer2.video.MediaCodecVideoDecoderException: Decoder failed: c2.qti.avc.decoder
                                                                                                          at com.google.android.exoplayer2.video.MediaCodecVideoRenderer.createDecoderException(MediaCodecVideoRenderer.java:1590)
                                                                                                          at com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.render(MediaCodecRenderer.java:813)
                                                                                                          at com.google.android.exoplayer2.ExoPlayerImplInternal.doSomeWork(ExoPlayerImplInternal.java:999)
                                                                                                          at com.google.android.exoplayer2.ExoPlayerImplInternal.handleMessage(ExoPlayerImplInternal.java:500)
                                                                                                          at android.os.Handler.dispatchMessage(Handler.java:102) 
                                                                                                          at android.os.Looper.loopOnce(Looper.java:201) 
                                                                                                          at android.os.Looper.loop(Looper.java:288) 
                                                                                                          at android.os.HandlerThread.run(HandlerThread.java:67) 
                                                                                                      Caused by: android.media.MediaCodec$CodecException: Error 0x80000000
2023-03-27 15:37:04.944 14857-14881 ExoPlayerImplInternal   com...ovin.player.samples.ads.basic  E  Disable failed.
                                                                                                      java.lang.IllegalStateException
                                                                                                          at android.media.MediaCodec.native_flush(Native Method)
                                                                                                          at android.media.MediaCodec.flush(MediaCodec.java:2387)
                                                                                                          at com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter.flush(AsynchronousMediaCodecAdapter.java:228)
                                                                                                          at com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.flushCodec(MediaCodecRenderer.java:877)
                                                                                                          at com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.flushOrReleaseCodec(MediaCodecRenderer.java:870)
                                                                                                          at com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.onDisabled(MediaCodecRenderer.java:710)
                                                                                                          at com.google.android.exoplayer2.video.MediaCodecVideoRenderer.onDisabled(MediaCodecVideoRenderer.java:561)
                                                                                                          at com.google.android.exoplayer2.BaseRenderer.disable(BaseRenderer.java:186)
                                                                                                          at com.google.android.exoplayer2.ExoPlayerImplInternal.disableRenderer(ExoPlayerImplInternal.java:1673)
                                                                                                          at com.google.android.exoplayer2.ExoPlayerImplInternal.resetInternal(ExoPlayerImplInternal.java:1407)
                                                                                                          at com.google.android.exoplayer2.ExoPlayerImplInternal.stopInternal(ExoPlayerImplInternal.java:1370)
                                                                                                          at com.google.android.exoplayer2.ExoPlayerImplInternal.handleMessage(ExoPlayerImplInternal.java:592)
                                                                                                          at android.os.Handler.dispatchMessage(Handler.java:102)
                                                                                                          at android.os.Looper.loopOnce(Looper.java:201)
                                                                                                          at android.os.Looper.loop(Looper.java:288)
                                                                                                          at android.os.HandlerThread.run(HandlerThread.java:67)
```