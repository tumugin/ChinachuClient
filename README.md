# ChinachuClient with Chromecast
sugtao4423氏作のChinachuClientにChromecastサポートと一部プログラムに修正を加えたもの

# 既存の不具合
* Chinachuの無認証サーバーでないとChromecastで再生できない(ChromecastはBASIC認証出来ない模様)

# オリジナルと比べた主な変更点
* appcompatへの対応のために一部ソースを変更
* Chromecastサポート
* MP4コンテナのサポート
* Gradleビルドに対応、IntelliJ IDEAで使えるように