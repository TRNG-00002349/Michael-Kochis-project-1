package com.revature.models;

import java.util.Objects;

public class StatBlock {
    private Long id;
    private int might;
    private int agility;
    private int valor;
    private int resolve;
    private int insight;
    private int charisma;

    public StatBlock() {
    }

    public StatBlock(int might, int agility, int valor, int resolve, int insight, int charisma) {
        this.setMight(might);
        this.setAgility(agility);
        this.setValor(valor);
        this.setResolve(resolve);
        this.setInsight(insight);
        this.setCharisma(charisma);
    }

    public StatBlock(Long id, int might, int agility, int valor, int resolve, int insight, int charisma) {
        this.setId(id);
        this.setMight(might);
        this.setAgility(agility);
        this.setValor(valor);
        this.setResolve(resolve);
        this.setInsight(insight);
        this.setCharisma(charisma);
    }

    public StatBlock(StatBlock other) {
        this.setId(other.getId());
        this.setMight(other.getMight());
        this.setAgility(other.getAgility());
        this.setValor(other.getValor());
        this.setResolve(other.getResolve());
        this.setInsight(other.getInsight());
        this.setCharisma(other.getCharisma());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMight() {
        return might;
    }

    public void setMight(int might) {
        this.might = might;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getResolve() {
        return resolve;
    }

    public void setResolve(int resolve) {
        this.resolve = resolve;
    }

    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatBlock statBlock = (StatBlock) o;
        return might == statBlock.might && agility == statBlock.agility
                && valor == statBlock.valor && resolve == statBlock.resolve
                && insight == statBlock.insight && charisma == statBlock.charisma
                && Objects.equals(id, statBlock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, might, agility, valor, resolve, insight, charisma);
    }
}
