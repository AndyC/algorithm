package datastructure.base;

/**
 * @author AndyCui
 * @date 2018/9/28 下午2:50
 * @description 算法分析
 */
public class MathSummary {
    /**
     * 定义1：如果存在正常数c和n0使得当N>=n0时有T（N）<=cf(N)，则记为T（N）=O（f(N)）。
     * T（N）的增长率小于或等于f（N）
     * 定义2：如果存在正常数c和n0使得当N>=no时有T（N）>=cg(N)，则记为T（N）=Ω（g(N)）。
     * T（N）的增长率大于或等于g（N）
     * 定义3：T（N）=ç（h(N)）当且仅当T（N）=O（h(N)）和 T(N)=θ(h(N))。
     * T（N）的增长率等于h(N)的增长率。
     * 定义4：如果对每一正常数c都存在常数n0使得当N>n0时T（N）<cp(N)则T（N）=o（p（N）），也可以说如果T（N）=O（p（N））且T（N）！=θ(p(N))。
     * T（N）的增长率小于p（N）的增长率，不同于O，O包含增长率相同的可能性。
     *
     * 重要结论：
     * （1）如果T1(N)=O(f(N))且T2（N）=O（g（N））那么T1（N）+T2（N）=O（f(N)+g(N)） T1(N)*T2(N)=O(f(N)*g(N))
     *（2）如果T（N）是一个K次多项式，则T(N)=θ(N^k)
     * (3)对任意常数K，logkN=O(N)，说明对数增长的非常缓慢。
     */
}
