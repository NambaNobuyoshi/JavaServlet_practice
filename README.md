# JavaServlet_practice
JavaServlet_practice
　作成者：NambaNobuyoshi　作成日：2022/05/24
 <実行方法>
 1.エクリプスで動的Webプロジェクトを作成
 　　1-1.プロジェクトエクスプローラーで右クリック
　　 1-2.新規＞プロジェクト
  　 1-3.動的Webプロジェクトを選択
 
 2.作成した動的Webプロジェクトに、ファイルを配置する
 　　src>main>java
   　src>main>webapp
 
 3.DBの用意
 　　3-1.SQLServerをインストール
　　 3-2.DBを新規作成する
 　  3-3.テーブルを作成する
     　　　テーブル名： memo
        　カラム：
         　　memoid         int           PRIMARY KEY
            memo_title      varchar(50)   NOT NULL
            memo_content    varchar(MAX)
            del_flg         int           NOT NULL
 .src/mein/java/practice02/SelectAll.java　を実行
 
 <プログラム概要>
 　メモの表示、登録、削除、編集が可能なメモアプリ
