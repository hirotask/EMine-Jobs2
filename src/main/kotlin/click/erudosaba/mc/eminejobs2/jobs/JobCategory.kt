package click.erudosaba.mc.eminejobs2.jobs

//列挙型JobCategory：職業の収益カテゴリ
enum class JobCategory {
    CUT,    //木を切る
    MINE,   //石を掘る
    DIG,    //土を掘る
    SLASH,  //剣でMOBを倒す
    SHOOT,  //弓でMOBを倒す
    FARM,   //農作業をする
    SMELT,  //精練する
    FISH,   //釣りをする
    CRAFT,  //クラフトする
    ENCHANT,    //エンチャントする
    FORGE,  //鍛冶をする
    BREW,   //ポーションをつくる
    BUILD,  //建築する
    GUN,    //銃を作る
    EAT,     //食べる
    INVALID
}