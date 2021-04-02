package click.erudosaba.mc.eminejobs2.skill.effect;

public enum Effect {
    //エフェクト名(説明，スキル有効時間)
    //スキル有効時間が0　→　即発動のスキル
    CutAll("木を一括破壊できる",0),
    WoodHaste1("10秒間採掘速度を上昇する",10),
    WoodHaste2("30秒間採掘速度を上昇する",30),
    WoodHaste3("50秒間採掘速度を上昇する",50),
    MineAll("鉱石ブロックを一括破壊できる(自分の立ってる高さ以下は破壊しない)",0),
    StoneHaste1("20秒間採掘速度を上昇する",20),
    StoneHaste2("40秒間採掘速度を上昇する",40),
    StoneHaste3("60秒間採掘速度を上昇する",60),
    DigAll("土系を一括破壊できる(自分の立ってる高さ以下は破壊しない)",0),
    DirtHaste1("20秒間採掘速度を上昇する",20),
    DirtHaste2("40秒間採掘速度を上昇する",40),
    DirtHaste3("60秒間採掘速度を上昇する",60),
    Slash1("スキル発動時に斬撃を飛ばして，あたったプレイヤーに持ってる剣のダメージ*1.3",0),
    Slash2("スキル発動時に斬撃を飛ばして，あたったプレイヤーに持ってる剣のダメージ*1.4 + 弱体化10秒",0),
    Slash3("スキル発動時に斬撃を飛ばして，あたったプレイヤーに持ってる剣のダメージ*1.5 + 弱体化15秒",0),
    SpeedArrow("10秒間自分が撃った矢に当たると空を飛べる。15秒間は落下ダメージが0となる。",10),
    PowerArrow("10秒間撃った矢が３方向に同時に飛ぶようになる",10),
    HomingArrow("10秒間撃った矢がホーミングする",10),
    Growing1("10秒間半径3ブロックの植物の成長速度を早める",10),
    Growing2("10秒間半径5ブロックの植物の成長速度を早める",10),
    Growing3("10秒間半径8ブロックの植物の成長速度を早める",10),
    AutoHarvest("20秒間自分が歩いた地点から半径3ブロックの範囲の作物を自動で破壊する",20),
    WallClimb("180秒間壁が上れる＋移動速度上昇2",180),
    FrostWalk("180秒間水の上を歩ける＋移動速度上昇2",180),
    Smelt1("180秒間精練速度が1.3倍",180),
    Smelt2("180秒間精練速度が1.6倍",180),
    Smelt3("180秒間精練速度が2倍",180),
    CatchFish("5秒間素手で水を右クリックすると魚が取れる（この時経験値は増えない）",5),
    RandomEffect1("30秒間の間にクラフトしたら，10秒間ランダムなエフェクト(lv.1)がつく",30),
    RandomEffect2("30秒間の間にクラフトしたら，10秒間ランダムなエフェクト(lv.2)がつく",30),
    RandomEffect3("30秒間の間にクラフトしたら，10秒間ランダムなエフェクト(lv.3)がつく",30),
    RandomUpgrade("10秒間の間にクラフトしたら，2%が上位のツールになる（木→石→鉄→金→ダイヤ→ネザライト）",10),
    TransEnchant("30秒間の間にエンチャントしたら，そのエンチャントの本が１つ手に入る",30),
    LowCostRepair1("10秒間の間に金床を使用すると，修理コストが（普通のコスト - 4)される",10),
    LowCostRepair2("10秒間の間に金床を使用すると，修理コストが（普通のコスト - 7)される",10),
    LowCostRepair3("10秒間の間に金床を使用すると，修理コストが（普通のコスト - 10)される",10),
    FastBrewing1("10秒間醸造の時間が0.8倍",10),
    FastBrewing2("10秒間醸造の時間が0.6倍",10),
    FastBrewing3("10秒間醸造の時間が0.4倍",10),
    Protean("30秒間ブロックを殴ると，左手に持っているブロックに殴ったブロックが変化する(鉱石ブロックはナシ)",30),
    Levitation("60秒間浮遊が可能",60),
    DoubleJump("60秒間スペースキーを２回押すと，２段ジャンプが可能",60),
    NoSlow1("20秒間食事中の移動速度が遅くならない",20),
    NoSlow2("40秒間食事中の移動速度が遅くならない",40),
    AlwaysFull("120秒間お腹が減らない",120);

    private String label;
    private int skilltime;

    private Effect(String label, int skilltime) {
        this.label = label;
        this.skilltime = skilltime;
    }

    public String getLabel() {
        return label;
    }

    public int getSkilltime() {
        return skilltime;
    }
}
