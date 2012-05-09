package testBinder.hadoop_yarn_common;

import java.io.PrintWriter;
import java.util.EnumSet;

import testBinder.extendsClause.SubView;
import static java.util.EnumSet.*;
import static testBinder.hadoop_yarn_common.HamletImpl.EOpt.*;

public class Hamlet extends HamletImpl implements HamletSpec._Html {
  public Hamlet(PrintWriter out, int nestLevel, boolean wasInline) {
    super(out, nestLevel, wasInline);
  }

  static EnumSet<EOpt> opt(boolean endTag, boolean inline, boolean pre) {
    EnumSet<EOpt> opts = of(ENDTAG);
    if (!endTag) opts.remove(ENDTAG);
    if (inline) opts.add(INLINE);
    if (pre) opts.add(PRE);
    return opts;
  }

  public class HTML<T extends _> extends EImp<T> implements HamletSpec.HTML {
    public HTML(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    public HTML<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    public HTML<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    public HEAD<HTML<T>> head() {
      closeAttrs();
      return head_(this, false);
    }

    public BODY<HTML<T>> body() {
      closeAttrs();
      return body_(this, false);
    }

    public BODY<HTML<T>> body(String selector) {
      return setSelector(body(), selector);
    }

    public BASE<HTML<T>> base() {
      closeAttrs();
      return base_(this, false);
    }

    public HTML<T> base(String href) {
      return base().$href(href)._();
    }

    public TITLE<HTML<T>> title() {
      closeAttrs();
      return title_(this, false);
    }

    public HTML<T> title(String cdata) {
      return title()._(cdata)._();
    }

    public STYLE<HTML<T>> style() {
      closeAttrs();
      return style_(this, false);
    }

    public HTML<T> style(Object... lines) {
      return style().$type("text/css")._(lines)._();
    }

    public LINK<HTML<T>> link() {
      closeAttrs();
      return link_(this, false);
    }

    public HTML<T> link(String href) {
      return setLinkHref(link(), href)._();
    }

    public META<HTML<T>> meta() {
      closeAttrs();
      return meta_(this, false);
    }

    public HTML<T> meta(String name, String content) {
      return meta().$name(name).$content(content)._();
    }
    
    public HTML<T> meta_http(String header, String content) {
      return meta().$http_equiv(header).$content(content)._();
    }

    public SCRIPT<HTML<T>> script() {
      closeAttrs();
      return script_(this, false);
    }

    public HTML<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    public OBJECT<HTML<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    public OBJECT<HTML<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    public TABLE<HTML<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    public TABLE<HTML<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    public HTML<T> address(String cdata) {
      return address()._(cdata)._();
    }

    public ADDRESS<HTML<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    public P<HTML<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    public P<HTML<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    public HTML<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    public HR<HTML<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    public HTML<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    public DL<HTML<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    public DL<HTML<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    public DIV<HTML<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    public DIV<HTML<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    public BLOCKQUOTE<HTML<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    public BLOCKQUOTE<HTML<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    public HTML<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    public H1<HTML<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    public HTML<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    public HTML<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    public H2<HTML<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    public HTML<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    public H3<HTML<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    public HTML<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    public HTML<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    public H4<HTML<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    public HTML<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    public HTML<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    public H5<HTML<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    public HTML<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    public HTML<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    public H6<HTML<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    public HTML<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    public HTML<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    public UL<HTML<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    public UL<HTML<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    public OL<HTML<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    public OL<HTML<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    public PRE<HTML<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    public PRE<HTML<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    public FORM<HTML<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    public FORM<HTML<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    public FIELDSET<HTML<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    public FIELDSET<HTML<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    public INS<HTML<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    public HTML<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    public DEL<HTML<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    public HTML<T> del(String cdata) {
      return del()._(cdata)._();
    }
  }

  private <T extends _> HEAD<T> head_(T e, boolean inline) {
    return new HEAD<T>("head", e, opt(true, inline, false)); }

  private <T extends _> BODY<T> body_(T e, boolean inline) {
    return new BODY<T>("body", e, opt(true, inline, false)); }

  public class SCRIPT<T extends _> extends EImp<T> implements HamletSpec.SCRIPT {
    public SCRIPT(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    public SCRIPT<T> $type(String value) {
      addAttr("type", value);
      return this;
    }

    public SCRIPT<T> $src(String value) {
      addAttr("src", value);
      return this;
    }

    public SCRIPT<T> $charset(String value) {
      addAttr("charset", value);
      return this;
    }

    public SCRIPT<T> $defer(String value) {
      addAttr("defer", value);
      return this;
    }

    public SCRIPT<T> _(Object... lines) {
      _p(false, lines);
      return this;
    }
  }

  public class STYLE<T extends _> extends EImp<T> implements HamletSpec.STYLE {
    public STYLE(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    public STYLE<T> $type(String value) {
      addAttr("type", value);
      return this;
    }

    public STYLE<T> $media(EnumSet<Media> value) {
      addMediaAttr("media", value);
      return this;
    }

    public STYLE<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    public STYLE<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    public STYLE<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    public STYLE<T> _(Object... lines) {
      _p(false, lines);
      return this;
    }
  }

  public class META<T extends _> extends EImp<T> implements HamletSpec.META {
    public META(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    public META<T> $http_equiv(String value) {
      addAttr("http-equiv", value);
      return this;
    }

    public META<T> $name(String value) {
      addAttr("name", value);
      return this;
    }

    public META<T> $content(String value) {
      addAttr("content", value);
      return this;
    }

    public META<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    public META<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }
  }

  public class BASE<T extends _> extends EImp<T> implements HamletSpec.BASE {
    public BASE(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    public BASE<T> $href(String value) {
      addAttr("href", value);
      return this;
    }
  }

  public class TITLE<T extends _> extends EImp<T> implements HamletSpec.TITLE {
    public TITLE(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    public TITLE<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    public TITLE<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public TITLE<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public TITLE<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }
  }

  public class HEAD<T extends _> extends EImp<T> implements HamletSpec.HEAD {
    public HEAD(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public HEAD<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public HEAD<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public BASE<HEAD<T>> base() {
      closeAttrs();
      return base_(this, false);
    }

    
    public HEAD<T> base(String href) {
      return base().$href(href)._();
    }

    
    public TITLE<HEAD<T>> title() {
      closeAttrs();
      return title_(this, false);
    }

    
    public HEAD<T> title(String cdata) {
      return title()._(cdata)._();
    }

    
    public STYLE<HEAD<T>> style() {
      closeAttrs();
      return style_(this, false);
    }

    
    public HEAD<T> style(Object... lines) {
      return style().$type("text/css")._(lines)._();
    }

    
    public LINK<HEAD<T>> link() {
      closeAttrs();
      return link_(this, false);
    }

    
    public HEAD<T> link(String href) {
      return setLinkHref(link(), href)._();
    }

    
    public META<HEAD<T>> meta() {
      closeAttrs();
      return meta_(this, false);
    }

    
    public HEAD<T> meta(String name, String content) {
      return meta().$name(name).$content(content)._();
    }

    
    public HEAD<T> meta_http(String header, String content) {
      return meta().$http_equiv(header).$content(content)._();
    }

    
    public SCRIPT<HEAD<T>> script() {
      closeAttrs();
      return script_(this, false);
    }

    
    public HEAD<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public OBJECT<HEAD<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<HEAD<T>> object(String selector) {
      return setSelector(object(), selector);
    }
  }

  private <T extends _> BASE<T> base_(T e, boolean inline) {
    return new BASE<T>("base", e, opt(false, inline, false)); }

  private <T extends _> TITLE<T> title_(T e, boolean inline) {
    return new TITLE<T>("title", e, opt(true, inline, false)); }

  public class TD<T extends _> extends EImp<T> implements HamletSpec.TD {
    public TD(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public TD<T> $headers(String value) {
      addAttr("headers", value);
      return this;
    }

    
    public TD<T> $scope(Scope value) {
      addAttr("scope", value);
      return this;
    }

    
    public TD<T> $rowspan(int value) {
      addAttr("rowspan", value);
      return this;
    }

    
    public TD<T> $colspan(int value) {
      addAttr("colspan", value);
      return this;
    }

    
    public TD<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public TD<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public TD<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public TD<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public TD<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public TD<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public TD<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public TD<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public TD<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public TD<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public TD<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public TD<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public TD<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public TD<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public TD<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public TD<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<TD<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<TD<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public TD<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<TD<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<TD<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<TD<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public TD<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<TD<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public TD<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<TD<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<TD<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<TD<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<TD<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<TD<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<TD<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public TD<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<TD<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public TD<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public TD<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<TD<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public TD<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<TD<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public TD<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public TD<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<TD<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public TD<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public TD<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<TD<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public TD<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public TD<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<TD<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public TD<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public TD<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<TD<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<TD<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<TD<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<TD<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<TD<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<TD<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<TD<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<TD<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<TD<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<TD<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public TD<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public TD<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<TD<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public TD<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public TD<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<TD<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public TD<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public TD<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<TD<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public TD<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public TD<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public TD<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<TD<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public TD<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<TD<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public TD<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public TD<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<TD<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public TD<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public TD<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<TD<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public TD<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public TD<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public TD<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<TD<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public TD<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<TD<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public TD<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public TD<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<TD<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public TD<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public TD<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<TD<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public TD<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public TD<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<TD<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public TD<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public TD<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<TD<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<TD<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public TD<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public TD<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<TD<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public TD<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<TD<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<TD<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<TD<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public TD<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public TD<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<TD<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public TD<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public TD<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<TD<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<TD<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public TD<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public TD<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<TD<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<TD<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public TD<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<TD<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public TD<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<TD<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public TD<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public TD<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<TD<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public TD<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<TD<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public TD<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<TD<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public TD<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<TD<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public TD<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<TD<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<TD<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<TD<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<TD<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<TD<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<TD<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public TD<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<TD<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<TD<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public TD<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class TH<T extends _> extends EImp<T> implements HamletSpec.TH {
    public TH(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public TH<T> $headers(String value) {
      addAttr("headers", value);
      return this;
    }

    
    public TH<T> $scope(Scope value) {
      addAttr("scope", value);
      return this;
    }

    
    public TH<T> $rowspan(int value) {
      addAttr("rowspan", value);
      return this;
    }

    
    public TH<T> $colspan(int value) {
      addAttr("colspan", value);
      return this;
    }

    
    public TH<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public TH<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public TH<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public TH<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public TH<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public TH<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public TH<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public TH<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public TH<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public TH<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public TH<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public TH<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public TH<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public TH<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public TH<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public TH<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<TH<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<TH<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public TH<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<TH<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<TH<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<TH<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public TH<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<TH<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public TH<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<TH<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<TH<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<TH<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<TH<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<TH<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<TH<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public TH<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<TH<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public TH<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public TH<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<TH<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public TH<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<TH<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public TH<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public TH<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<TH<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public TH<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public TH<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<TH<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public TH<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public TH<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<TH<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public TH<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public TH<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<TH<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<TH<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<TH<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<TH<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<TH<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<TH<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<TH<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<TH<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<TH<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<TH<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public TH<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public TH<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<TH<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public TH<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public TH<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<TH<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public TH<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public TH<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<TH<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public TH<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public TH<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public TH<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<TH<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public TH<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<TH<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public TH<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public TH<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<TH<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public TH<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public TH<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<TH<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public TH<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public TH<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public TH<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<TH<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public TH<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<TH<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public TH<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public TH<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<TH<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public TH<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public TH<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<TH<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public TH<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public TH<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<TH<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public TH<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public TH<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<TH<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<TH<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public TH<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public TH<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<TH<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public TH<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<TH<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<TH<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<TH<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public TH<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public TH<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<TH<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public TH<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public TH<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<TH<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<TH<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public TH<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public TH<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<TH<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<TH<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public TH<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<TH<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public TH<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<TH<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public TH<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public TH<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<TH<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public TH<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<TH<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public TH<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<TH<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public TH<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<TH<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public TH<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<TH<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<TH<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<TH<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<TH<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<TH<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<TH<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public TH<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<TH<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<TH<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public TH<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class TR<T extends _> extends EImp<T> implements HamletSpec.TR {
    public TR(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public TR<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public TR<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public TR<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public TR<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public TR<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public TR<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public TR<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public TR<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public TR<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public TR<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public TR<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public TR<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public TR<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public TR<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public TR<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public TR<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TH<TR<T>> th() {
      closeAttrs();
      return th_(this, false);
    }

    
    public TR<T> th(String cdata) {
      return th()._(cdata)._();
    }

    
    public TR<T> th(String selector, String cdata) {
      return setSelector(th(), selector)._(cdata)._();
    }

    
    public TD<TR<T>> td() {
      closeAttrs();
      return td_(this, false);
    }

    
    public TR<T> td(String cdata) {
      return td()._(cdata)._();
    }

    
    public TR<T> td(String selector, String cdata) {
      return setSelector(td(), selector)._(cdata)._();
    }
  }

  private <T extends _> TH<T> th_(T e, boolean inline) {
    return new TH<T>("th", e, opt(false, inline, false)); }

  private <T extends _> TD<T> td_(T e, boolean inline) {
    return new TD<T>("td", e, opt(false, inline, false)); }

  public class COL<T extends _> extends EImp<T> implements HamletSpec.COL {
    public COL(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public COL<T> $span(int value) {
      addAttr("span", value);
      return this;
    }

    
    public COL<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public COL<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public COL<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public COL<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public COL<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public COL<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public COL<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public COL<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public COL<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public COL<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public COL<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public COL<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public COL<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public COL<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public COL<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public COL<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }
  }

  public class COLGROUP<T extends _> extends EImp<T> implements HamletSpec.COLGROUP {
    public COLGROUP(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public COLGROUP<T> $span(int value) {
      addAttr("span", value);
      return this;
    }

    
    public COLGROUP<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public COLGROUP<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public COLGROUP<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public COLGROUP<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public COLGROUP<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public COLGROUP<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public COLGROUP<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public COLGROUP<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public COLGROUP<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public COLGROUP<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public COLGROUP<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public COLGROUP<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public COLGROUP<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public COLGROUP<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public COLGROUP<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public COLGROUP<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public COL<COLGROUP<T>> col() {
      closeAttrs();
      return col_(this, false);
    }

    
    public COLGROUP<T> col(String selector) {
      return setSelector(col(), selector)._();
    }
  }

  public class TBODY<T extends _> extends EImp<T> implements HamletSpec.TBODY {
    public TBODY(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public TBODY<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public TBODY<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public TBODY<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public TBODY<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public TBODY<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public TBODY<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public TBODY<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public TBODY<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public TBODY<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public TBODY<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public TBODY<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public TBODY<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public TBODY<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public TBODY<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public TBODY<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public TBODY<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TR<TBODY<T>> tr() {
      closeAttrs();
      return tr_(this, false);
    }

    
    public TR<TBODY<T>> tr(String selector) {
      return setSelector(tr(), selector);
    }
  }

  public class TFOOT<T extends _> extends EImp<T> implements HamletSpec.TFOOT {
    public TFOOT(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public TFOOT<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public TFOOT<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public TFOOT<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public TFOOT<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public TFOOT<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public TFOOT<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public TFOOT<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public TFOOT<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public TFOOT<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public TFOOT<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public TFOOT<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public TFOOT<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public TFOOT<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public TFOOT<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public TFOOT<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public TFOOT<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TR<TFOOT<T>> tr() {
      closeAttrs();
      return tr_(this, false);
    }

    
    public TR<TFOOT<T>> tr(String selector) {
      return setSelector(tr(), selector);
    }
  }

  public class THEAD<T extends _> extends EImp<T> implements HamletSpec.THEAD {
    public THEAD(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public THEAD<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public THEAD<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public THEAD<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public THEAD<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public THEAD<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public THEAD<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public THEAD<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public THEAD<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public THEAD<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public THEAD<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public THEAD<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public THEAD<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public THEAD<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public THEAD<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public THEAD<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public THEAD<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TR<THEAD<T>> tr() {
      closeAttrs();
      return tr_(this, false);
    }

    
    public TR<THEAD<T>> tr(String selector) {
      return setSelector(tr(), selector);
    }
  }

  public class CAPTION<T extends _> extends EImp<T> implements HamletSpec.CAPTION {
    public CAPTION(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public CAPTION<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public CAPTION<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public CAPTION<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public CAPTION<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public CAPTION<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public CAPTION<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public CAPTION<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public CAPTION<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public CAPTION<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public CAPTION<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public CAPTION<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public CAPTION<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public CAPTION<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public CAPTION<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public CAPTION<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public CAPTION<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public CAPTION<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public CAPTION<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<CAPTION<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public CAPTION<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public CAPTION<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<CAPTION<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public CAPTION<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public CAPTION<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<CAPTION<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public CAPTION<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public CAPTION<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public CAPTION<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<CAPTION<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public CAPTION<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<CAPTION<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public CAPTION<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public CAPTION<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<CAPTION<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public CAPTION<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public CAPTION<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<CAPTION<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public CAPTION<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public CAPTION<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public CAPTION<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<CAPTION<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public CAPTION<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<CAPTION<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public CAPTION<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public CAPTION<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<CAPTION<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public CAPTION<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public CAPTION<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<CAPTION<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public CAPTION<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public CAPTION<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<CAPTION<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public CAPTION<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public CAPTION<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<CAPTION<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<CAPTION<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public CAPTION<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public CAPTION<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<CAPTION<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public CAPTION<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<CAPTION<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<CAPTION<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<CAPTION<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public CAPTION<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public CAPTION<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<CAPTION<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public CAPTION<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public CAPTION<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<CAPTION<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<CAPTION<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public CAPTION<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public CAPTION<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<CAPTION<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<CAPTION<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public CAPTION<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<CAPTION<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public CAPTION<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<CAPTION<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public CAPTION<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public CAPTION<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<CAPTION<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public CAPTION<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<CAPTION<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public CAPTION<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<CAPTION<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public CAPTION<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<CAPTION<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public CAPTION<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<CAPTION<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<CAPTION<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<CAPTION<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<CAPTION<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<CAPTION<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<CAPTION<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public CAPTION<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<CAPTION<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<CAPTION<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public CAPTION<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class TABLE<T extends _> extends EImp<T> implements HamletSpec.TABLE {
    public TABLE(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public TABLE<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public TABLE<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public TABLE<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public TABLE<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public TABLE<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public TABLE<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public TABLE<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public TABLE<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public TABLE<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public TABLE<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public TABLE<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public TABLE<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public TABLE<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public TABLE<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public TABLE<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public TABLE<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<T> caption(String cdata) {
      return caption()._(cdata)._();
    }

    
    public CAPTION<TABLE<T>> caption() {
      closeAttrs();
      return caption_(this, false);
    }

    
    public COLGROUP<TABLE<T>> colgroup() {
      closeAttrs();
      return colgroup_(this, false);
    }

    
    public THEAD<TABLE<T>> thead(String selector) {
      return setSelector(thead(), selector);
    }

    
    public THEAD<TABLE<T>> thead() {
      closeAttrs();
      return thead_(this, false);
    }

    
    public TFOOT<TABLE<T>> tfoot() {
      closeAttrs();
      return tfoot_(this, false);
    }

    
    public TFOOT<TABLE<T>> tfoot(String selector) {
      return setSelector(tfoot(), selector);
    }

    
    public TBODY<TABLE<T>> tbody() {
      closeAttrs();
      return tbody_(this, false);
    }

    
    public TBODY<TABLE<T>> tbody(String selector) {
      return setSelector(tbody(), selector);
    }

    
    public TR<TABLE<T>> tr() {
      closeAttrs();
      return tr_(this, false);
    }

    
    public TR<TABLE<T>> tr(String selector) {
      return setSelector(tr(), selector);
    }

    
    public COL<TABLE<T>> col() {
      closeAttrs();
      return col_(this, false);
    }

    
    public TABLE<T> col(String selector) {
      return setSelector(col(), selector)._();
    }
  }

  private <T extends _> CAPTION<T> caption_(T e, boolean inline) {
    return new CAPTION<T>("caption", e, opt(true, inline, false)); }

  private <T extends _> COLGROUP<T> colgroup_(T e, boolean inline) {
    return new COLGROUP<T>("colgroup", e, opt(false, inline, false)); }

  private <T extends _> THEAD<T> thead_(T e, boolean inline) {
    return new THEAD<T>("thead", e, opt(false, inline, false)); }

  private <T extends _> TFOOT<T> tfoot_(T e, boolean inline) {
    return new TFOOT<T>("tfoot", e, opt(false, inline, false)); }

  private <T extends _> TBODY<T> tbody_(T e, boolean inline) {
    return new TBODY<T>("tbody", e, opt(true, inline, false)); }

  private <T extends _> COL<T> col_(T e, boolean inline) {
    return new COL<T>("col", e, opt(false, inline, false)); }

  private <T extends _> TR<T> tr_(T e, boolean inline) {
    return new TR<T>("tr", e, opt(false, inline, false)); }

  public class BUTTON<T extends _> extends EImp<T> implements HamletSpec.BUTTON {
    public BUTTON(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public BUTTON<T> $type(ButtonType value) {
      addAttr("type", value);
      return this;
    }

    
    public BUTTON<T> $name(String value) {
      addAttr("name", value);
      return this;
    }

    
    public BUTTON<T> $value(String value) {
      addAttr("value", value);
      return this;
    }

    
    public BUTTON<T> $disabled() {
      addAttr("disabled", null);
      return this;
    }

    
    public BUTTON<T> $tabindex(int value) {
      addAttr("tabindex", value);
      return this;
    }

    
    public BUTTON<T> $accesskey(String value) {
      addAttr("accesskey", value);
      return this;
    }

    
    public BUTTON<T> $onfocus(String value) {
      addAttr("onfocus", value);
      return this;
    }

    
    public BUTTON<T> $onblur(String value) {
      addAttr("onblur", value);
      return this;
    }

    
    public TABLE<BUTTON<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<BUTTON<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public BUTTON<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<BUTTON<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<BUTTON<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<BUTTON<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public BUTTON<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<BUTTON<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public BUTTON<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<BUTTON<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<BUTTON<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<BUTTON<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<BUTTON<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<BUTTON<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<BUTTON<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BUTTON<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<BUTTON<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public BUTTON<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public BUTTON<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<BUTTON<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public BUTTON<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<BUTTON<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public BUTTON<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public BUTTON<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<BUTTON<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public BUTTON<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public BUTTON<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<BUTTON<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public BUTTON<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public BUTTON<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<BUTTON<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public BUTTON<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public BUTTON<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<BUTTON<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<BUTTON<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<BUTTON<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<BUTTON<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<BUTTON<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<BUTTON<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public BUTTON<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public BUTTON<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<BUTTON<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public BUTTON<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public BUTTON<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<BUTTON<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public BUTTON<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public BUTTON<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<BUTTON<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public BUTTON<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public BUTTON<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public BUTTON<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<BUTTON<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public BUTTON<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<BUTTON<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public BUTTON<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public BUTTON<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<BUTTON<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public BUTTON<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public BUTTON<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<BUTTON<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public BUTTON<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public BUTTON<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public BUTTON<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<BUTTON<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public BUTTON<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<BUTTON<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public BUTTON<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public BUTTON<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<BUTTON<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public BUTTON<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public BUTTON<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<BUTTON<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public BUTTON<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public BUTTON<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<BUTTON<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public BUTTON<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public BUTTON<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public MAP<BUTTON<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<BUTTON<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public BUTTON<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public BUTTON<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<BUTTON<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<BUTTON<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public BUTTON<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<BUTTON<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public BUTTON<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<BUTTON<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public BUTTON<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public BUTTON<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<BUTTON<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public BUTTON<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<BUTTON<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public BUTTON<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<BUTTON<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public BUTTON<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public IMG<BUTTON<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public BUTTON<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<BUTTON<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<BUTTON<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<BUTTON<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public BUTTON<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public BUTTON<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<BUTTON<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public BUTTON<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public BUTTON<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public BUTTON<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public BUTTON<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public BUTTON<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public BUTTON<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public BUTTON<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public BUTTON<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public BUTTON<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public BUTTON<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public BUTTON<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public BUTTON<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public BUTTON<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public BUTTON<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public BUTTON<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public BUTTON<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public BUTTON<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public BUTTON<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }
  }

  public class LEGEND<T extends _> extends EImp<T> implements HamletSpec.LEGEND {
    public LEGEND(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public LEGEND<T> $accesskey(String value) {
      addAttr("accesskey", value);
      return this;
    }

    
    public LEGEND<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public LEGEND<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public LEGEND<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public LEGEND<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public LEGEND<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public LEGEND<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public LEGEND<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public LEGEND<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public LEGEND<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public LEGEND<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public LEGEND<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public LEGEND<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public LEGEND<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public LEGEND<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public LEGEND<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public LEGEND<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public LEGEND<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public LEGEND<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<LEGEND<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public LEGEND<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public LEGEND<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<LEGEND<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public LEGEND<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public LEGEND<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<LEGEND<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public LEGEND<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public LEGEND<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public LEGEND<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<LEGEND<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public LEGEND<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<LEGEND<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public LEGEND<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public LEGEND<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<LEGEND<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public LEGEND<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public LEGEND<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<LEGEND<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public LEGEND<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public LEGEND<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public LEGEND<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<LEGEND<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public LEGEND<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<LEGEND<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public LEGEND<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public LEGEND<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<LEGEND<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public LEGEND<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public LEGEND<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<LEGEND<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public LEGEND<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public LEGEND<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<LEGEND<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public LEGEND<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public LEGEND<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<LEGEND<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<LEGEND<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public LEGEND<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public LEGEND<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<LEGEND<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public LEGEND<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<LEGEND<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<LEGEND<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<LEGEND<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public LEGEND<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public LEGEND<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<LEGEND<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public LEGEND<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public LEGEND<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<LEGEND<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<LEGEND<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public LEGEND<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public LEGEND<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<LEGEND<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<LEGEND<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public LEGEND<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<LEGEND<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public LEGEND<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<LEGEND<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public LEGEND<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public LEGEND<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<LEGEND<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public LEGEND<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<LEGEND<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public LEGEND<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<LEGEND<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public LEGEND<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<LEGEND<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public LEGEND<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<LEGEND<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<LEGEND<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<LEGEND<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<LEGEND<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<LEGEND<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<LEGEND<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public LEGEND<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<LEGEND<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<LEGEND<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public LEGEND<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class FIELDSET<T extends _> extends EImp<T> implements HamletSpec.FIELDSET {
    public FIELDSET(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public FIELDSET<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public FIELDSET<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public FIELDSET<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public FIELDSET<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public FIELDSET<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public FIELDSET<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public FIELDSET<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public FIELDSET<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public FIELDSET<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public FIELDSET<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public FIELDSET<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public FIELDSET<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public FIELDSET<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public FIELDSET<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public FIELDSET<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public FIELDSET<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public LEGEND<FIELDSET<T>> legend() {
      closeAttrs();
      return legend_(this, false);
    }

    
    public FIELDSET<T> legend(String cdata) {
      return legend()._(cdata)._();
    }

    
    public FIELDSET<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public FIELDSET<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public TABLE<FIELDSET<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<FIELDSET<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public FIELDSET<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<FIELDSET<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<FIELDSET<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<FIELDSET<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public FIELDSET<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<FIELDSET<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public FIELDSET<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<FIELDSET<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<FIELDSET<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<FIELDSET<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<FIELDSET<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<FIELDSET<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<FIELDSET<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public FIELDSET<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<FIELDSET<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public FIELDSET<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public FIELDSET<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<FIELDSET<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public FIELDSET<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<FIELDSET<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public FIELDSET<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public FIELDSET<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<FIELDSET<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public FIELDSET<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public FIELDSET<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<FIELDSET<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public FIELDSET<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public FIELDSET<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<FIELDSET<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public FIELDSET<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public FIELDSET<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<FIELDSET<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<FIELDSET<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<FIELDSET<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<FIELDSET<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<FIELDSET<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<FIELDSET<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<FIELDSET<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<FIELDSET<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<FIELDSET<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<FIELDSET<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public B<FIELDSET<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public FIELDSET<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public FIELDSET<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<FIELDSET<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public FIELDSET<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public FIELDSET<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<FIELDSET<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public FIELDSET<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public FIELDSET<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public FIELDSET<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<FIELDSET<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public FIELDSET<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<FIELDSET<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public FIELDSET<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public FIELDSET<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<FIELDSET<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public FIELDSET<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public FIELDSET<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<FIELDSET<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public FIELDSET<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public FIELDSET<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public FIELDSET<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<FIELDSET<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public FIELDSET<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<FIELDSET<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public FIELDSET<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public FIELDSET<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<FIELDSET<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public FIELDSET<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public FIELDSET<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<FIELDSET<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public FIELDSET<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public FIELDSET<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<FIELDSET<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public FIELDSET<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public FIELDSET<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<FIELDSET<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<FIELDSET<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public FIELDSET<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public FIELDSET<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<FIELDSET<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public FIELDSET<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<FIELDSET<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<FIELDSET<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<FIELDSET<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public FIELDSET<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public FIELDSET<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<FIELDSET<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public FIELDSET<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public FIELDSET<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<FIELDSET<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<FIELDSET<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public FIELDSET<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public FIELDSET<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<FIELDSET<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<FIELDSET<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public FIELDSET<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<FIELDSET<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public FIELDSET<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<FIELDSET<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public FIELDSET<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public FIELDSET<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<FIELDSET<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public FIELDSET<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<FIELDSET<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public FIELDSET<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<FIELDSET<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public FIELDSET<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<FIELDSET<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public FIELDSET<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<FIELDSET<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<FIELDSET<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<FIELDSET<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<FIELDSET<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<FIELDSET<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<FIELDSET<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public FIELDSET<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<FIELDSET<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<FIELDSET<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public FIELDSET<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  private <T extends _> LEGEND<T> legend_(T e, boolean inline) {
    return new LEGEND<T>("legend", e, opt(true, inline, false)); }

  public class TEXTAREA<T extends _> extends EImp<T> implements HamletSpec.TEXTAREA {
    public TEXTAREA(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public TEXTAREA<T> $name(String value) {
      addAttr("name", value);
      return this;
    }

    
    public TEXTAREA<T> $disabled() {
      addAttr("disabled", null);
      return this;
    }

    
    public TEXTAREA<T> $tabindex(int value) {
      addAttr("tabindex", value);
      return this;
    }

    
    public TEXTAREA<T> $accesskey(String value) {
      addAttr("accesskey", value);
      return this;
    }

    
    public TEXTAREA<T> $onfocus(String value) {
      addAttr("onfocus", value);
      return this;
    }

    
    public TEXTAREA<T> $onblur(String value) {
      addAttr("onblur", value);
      return this;
    }

    
    public TEXTAREA<T> $rows(int value) {
      addAttr("rows", value);
      return this;
    }

    
    public TEXTAREA<T> $cols(int value) {
      addAttr("cols", value);
      return this;
    }

    
    public TEXTAREA<T> $readonly() {
      addAttr("readonly", null);
      return this;
    }

    
    public TEXTAREA<T> $onselect(String value) {
      addAttr("onselect", value);
      return this;
    }

    
    public TEXTAREA<T> $onchange(String value) {
      addAttr("onchange", value);
      return this;
    }

    
    public TEXTAREA<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public TEXTAREA<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public TEXTAREA<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public TEXTAREA<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public TEXTAREA<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public TEXTAREA<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public TEXTAREA<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public TEXTAREA<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public TEXTAREA<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public TEXTAREA<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public TEXTAREA<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public TEXTAREA<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public TEXTAREA<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public TEXTAREA<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public TEXTAREA<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public TEXTAREA<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TEXTAREA<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public TEXTAREA<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }
  }

  public class OPTION<T extends _> extends EImp<T> implements HamletSpec.OPTION {
    public OPTION(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public OPTION<T> $value(String value) {
      addAttr("value", value);
      return this;
    }

    
    public OPTION<T> $disabled() {
      addAttr("disabled", null);
      return this;
    }

    
    public OPTION<T> $selected() {
      addAttr("selected", null);
      return this;
    }

    
    public OPTION<T> $label(String value) {
      addAttr("label", value);
      return this;
    }

    
    public OPTION<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public OPTION<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public OPTION<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public OPTION<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public OPTION<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public OPTION<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public OPTION<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public OPTION<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public OPTION<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public OPTION<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public OPTION<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public OPTION<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public OPTION<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public OPTION<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public OPTION<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public OPTION<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public OPTION<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public OPTION<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }
  }

  public class OPTGROUP<T extends _> extends EImp<T> implements HamletSpec.OPTGROUP {
    public OPTGROUP(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public OPTGROUP<T> $disabled() {
      addAttr("disabled", null);
      return this;
    }

    
    public OPTGROUP<T> $label(String value) {
      addAttr("label", value);
      return this;
    }

    
    public OPTGROUP<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public OPTGROUP<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public OPTGROUP<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public OPTGROUP<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public OPTGROUP<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public OPTGROUP<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public OPTGROUP<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public OPTGROUP<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public OPTGROUP<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public OPTGROUP<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public OPTGROUP<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public OPTGROUP<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public OPTGROUP<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public OPTGROUP<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public OPTGROUP<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public OPTGROUP<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public OPTION<OPTGROUP<T>> option() {
      closeAttrs();
      return option_(this, false);
    }

    
    public OPTGROUP<T> option(String cdata) {
      return option()._(cdata)._();
    }
  }

  private <T extends _> OPTGROUP<T> optgroup_(T e, boolean inline) {
    return new OPTGROUP<T>("optgroup", e, opt(true, inline, false)); }

  public class SELECT<T extends _> extends EImp<T> implements HamletSpec.SELECT {
    public SELECT(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public SELECT<T> $name(String value) {
      addAttr("name", value);
      return this;
    }

    
    public SELECT<T> $disabled() {
      addAttr("disabled", null);
      return this;
    }

    
    public SELECT<T> $tabindex(int value) {
      addAttr("tabindex", value);
      return this;
    }

    
    public SELECT<T> $onfocus(String value) {
      addAttr("onfocus", value);
      return this;
    }

    
    public SELECT<T> $onblur(String value) {
      addAttr("onblur", value);
      return this;
    }

    
    public SELECT<T> $onchange(String value) {
      addAttr("onchange", value);
      return this;
    }

    
    public OPTGROUP<SELECT<T>> optgroup() {
      closeAttrs();
      return optgroup_(this, false);
    }

    
    public SELECT<T> $size(int value) {
      addAttr("size", value);
      return this;
    }

    
    public SELECT<T> $multiple() {
      addAttr("multiple", null);
      return this;
    }

    
    public SELECT<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public SELECT<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public SELECT<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public SELECT<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public SELECT<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public SELECT<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public SELECT<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public SELECT<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public SELECT<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public SELECT<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public SELECT<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public SELECT<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public SELECT<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public SELECT<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public SELECT<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public SELECT<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public OPTION<SELECT<T>> option() {
      closeAttrs();
      return option_(this, false);
    }

    
    public SELECT<T> option(String cdata) {
      return option()._(cdata)._();
    }
  }

  private <T extends _> OPTION<T> option_(T e, boolean inline) {
    return new OPTION<T>("option", e, opt(false, inline, false)); }

  public class INPUT<T extends _> extends EImp<T> implements HamletSpec.INPUT {
    public INPUT(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public INPUT<T> $type(InputType value) {
      addAttr("type", value);
      return this;
    }

    
    public INPUT<T> $src(String value) {
      addAttr("src", value);
      return this;
    }

    
    public INPUT<T> $name(String value) {
      addAttr("name", value);
      return this;
    }

    
    public INPUT<T> $value(String value) {
      addAttr("value", value);
      return this;
    }

    
    public INPUT<T> $disabled() {
      addAttr("disabled", null);
      return this;
    }

    
    public INPUT<T> $tabindex(int value) {
      addAttr("tabindex", value);
      return this;
    }

    
    public INPUT<T> $accesskey(String value) {
      addAttr("accesskey", value);
      return this;
    }

    
    public INPUT<T> $onfocus(String value) {
      addAttr("onfocus", value);
      return this;
    }

    
    public INPUT<T> $onblur(String value) {
      addAttr("onblur", value);
      return this;
    }

    
    public INPUT<T> $readonly() {
      addAttr("readonly", null);
      return this;
    }

    
    public INPUT<T> $onselect(String value) {
      addAttr("onselect", value);
      return this;
    }

    
    public INPUT<T> $onchange(String value) {
      addAttr("onchange", value);
      return this;
    }

    
    public INPUT<T> $size(String value) {
      addAttr("size", value);
      return this;
    }

    
    public INPUT<T> $checked() {
      addAttr("checked", null);
      return this;
    }

    
    public INPUT<T> $maxlength(int value) {
      addAttr("maxlength", value);
      return this;
    }

    
    public INPUT<T> $alt(String value) {
      addAttr("alt", value);
      return this;
    }

    
    public INPUT<T> $ismap() {
      addAttr("ismap", null);
      return this;
    }

    
    public INPUT<T> $accept(String value) {
      addAttr("accept", value);
      return this;
    }

    
    public INPUT<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public INPUT<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public INPUT<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public INPUT<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public INPUT<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public INPUT<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public INPUT<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public INPUT<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public INPUT<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public INPUT<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public INPUT<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public INPUT<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public INPUT<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public INPUT<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public INPUT<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public INPUT<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }
  }

  public class LABEL<T extends _> extends EImp<T> implements HamletSpec.LABEL {
    public LABEL(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public LABEL<T> $accesskey(String value) {
      addAttr("accesskey", value);
      return this;
    }

    
    public LABEL<T> $onfocus(String value) {
      addAttr("onfocus", value);
      return this;
    }

    
    public LABEL<T> $onblur(String value) {
      addAttr("onblur", value);
      return this;
    }

    
    public LABEL<T> $for(String value) {
      addAttr("for", value);
      return this;
    }

    
    public LABEL<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public LABEL<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public LABEL<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public LABEL<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public LABEL<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public LABEL<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public LABEL<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public LABEL<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public LABEL<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public LABEL<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public LABEL<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public LABEL<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public LABEL<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public LABEL<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public LABEL<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public LABEL<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public LABEL<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public LABEL<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<LABEL<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public LABEL<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public LABEL<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<LABEL<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public LABEL<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public LABEL<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<LABEL<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public LABEL<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public LABEL<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public LABEL<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<LABEL<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public LABEL<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<LABEL<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public LABEL<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public LABEL<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<LABEL<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public LABEL<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public LABEL<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<LABEL<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public LABEL<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public LABEL<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public LABEL<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<LABEL<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public LABEL<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<LABEL<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public LABEL<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public LABEL<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<LABEL<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public LABEL<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public LABEL<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<LABEL<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public LABEL<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public LABEL<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<LABEL<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public LABEL<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public LABEL<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<LABEL<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<LABEL<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public LABEL<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public LABEL<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<LABEL<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public LABEL<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<LABEL<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<LABEL<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<LABEL<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public LABEL<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public LABEL<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<LABEL<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public LABEL<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public LABEL<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<LABEL<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<LABEL<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public LABEL<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public LABEL<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<LABEL<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<LABEL<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public LABEL<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<LABEL<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public LABEL<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<LABEL<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public LABEL<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public LABEL<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<LABEL<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public LABEL<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<LABEL<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public LABEL<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<LABEL<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public LABEL<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public INPUT<LABEL<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<LABEL<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<LABEL<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<LABEL<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<LABEL<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<LABEL<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public LABEL<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<LABEL<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<LABEL<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public LABEL<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class FORM<T extends _> extends EImp<T> implements HamletSpec.FORM {
    public FORM(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public FORM<T> $name(String value) {
      addAttr("name", value);
      return this;
    }

    
    public FORM<T> $accept(String value) {
      addAttr("accept", value);
      return this;
    }

    
    public FORM<T> $action(String value) {
      addAttr("action", value);
      return this;
    }

    
    public FORM<T> $method(Method value) {
      addAttr("method", value);
      return this;
    }

    
    public FORM<T> $enctype(String value) {
      addAttr("enctype", value);
      return this;
    }

    
    public FORM<T> $onsubmit(String value) {
      addAttr("onsubmit", value);
      return this;
    }

    
    public FORM<T> $onreset(String value) {
      addAttr("onreset", value);
      return this;
    }

    
    public FORM<T> $accept_charset(String value) {
      addAttr("accept-charset", value);
      return this;
    }

    
    public FORM<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public FORM<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public FORM<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public FORM<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public FORM<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public FORM<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public FORM<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public FORM<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public FORM<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public FORM<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public FORM<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public FORM<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public FORM<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public FORM<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public FORM<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public FORM<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public SCRIPT<FORM<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public FORM<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public TABLE<FORM<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<FORM<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public FORM<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<FORM<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<FORM<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<FORM<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public FORM<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<FORM<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public FORM<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<FORM<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<FORM<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<FORM<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<FORM<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<FORM<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<FORM<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public FORM<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<FORM<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public FORM<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public FORM<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<FORM<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public FORM<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<FORM<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public FORM<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public FORM<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<FORM<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public FORM<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public FORM<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<FORM<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public FORM<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public FORM<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<FORM<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public FORM<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public FORM<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<FORM<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<FORM<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<FORM<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<FORM<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<FORM<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<FORM<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FIELDSET<FORM<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<FORM<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }
  }

  public class LI<T extends _> extends EImp<T> implements HamletSpec.LI {
    public LI(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public LI<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public LI<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public LI<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public LI<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public LI<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public LI<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public LI<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public LI<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public LI<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public LI<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public LI<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public LI<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public LI<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public LI<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public LI<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public LI<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<LI<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<LI<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public LI<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<LI<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<LI<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<LI<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public LI<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<LI<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public LI<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<LI<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<LI<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<LI<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<LI<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<LI<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<LI<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public LI<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<LI<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public LI<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public LI<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<LI<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public LI<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<LI<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public LI<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public LI<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<LI<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public LI<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public LI<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<LI<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public LI<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public LI<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<LI<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public LI<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public LI<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<LI<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<LI<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<LI<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<LI<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<LI<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<LI<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<LI<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<LI<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<LI<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<LI<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public LI<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public LI<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<LI<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public LI<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public LI<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<LI<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public LI<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public LI<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<LI<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public LI<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public LI<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public LI<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<LI<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public LI<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<LI<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public LI<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public LI<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<LI<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public LI<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public LI<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<LI<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public LI<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public LI<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public LI<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<LI<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public LI<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<LI<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public LI<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public LI<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<LI<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public LI<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public LI<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<LI<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public LI<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public LI<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<LI<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public LI<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public LI<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<LI<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<LI<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public LI<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public LI<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<LI<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public LI<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<LI<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<LI<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<LI<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public LI<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public LI<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<LI<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public LI<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public LI<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<LI<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<LI<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public LI<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public LI<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<LI<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<LI<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public LI<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<LI<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public LI<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<LI<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public LI<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public LI<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<LI<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public LI<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<LI<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public LI<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<LI<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public LI<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<LI<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public LI<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<LI<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<LI<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<LI<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<LI<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<LI<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<LI<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public LI<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<LI<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<LI<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public LI<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class UL<T extends _> extends EImp<T> implements HamletSpec.UL {
    public UL(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public UL<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public UL<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public UL<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public UL<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public UL<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public UL<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public UL<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public UL<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public UL<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public UL<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public UL<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public UL<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public UL<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public UL<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public UL<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public UL<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public LI<UL<T>> li() {
      closeAttrs();
      return li_(this, false);
    }

    
    public UL<T> li(String cdata) {
      return li()._(cdata)._();
    }
  }

  public class OL<T extends _> extends EImp<T> implements HamletSpec.OL {
    public OL(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public OL<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public OL<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public OL<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public OL<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public OL<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public OL<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public OL<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public OL<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public OL<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public OL<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public OL<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public OL<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public OL<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public OL<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public OL<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public OL<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public LI<OL<T>> li() {
      closeAttrs();
      return li_(this, false);
    }

    
    public OL<T> li(String cdata) {
      return li()._(cdata)._();
    }
  }

  private <T extends _> LI<T> li_(T e, boolean inline) {
    return new LI<T>("li", e, opt(false, inline, false)); }

  public class DD<T extends _> extends EImp<T> implements HamletSpec.DD {
    public DD(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public DD<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public DD<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public DD<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public DD<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public DD<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public DD<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public DD<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public DD<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public DD<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public DD<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public DD<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public DD<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public DD<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public DD<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public DD<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public DD<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<DD<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<DD<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public DD<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<DD<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<DD<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<DD<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public DD<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<DD<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public DD<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<DD<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<DD<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<DD<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<DD<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<DD<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<DD<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public DD<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<DD<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public DD<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public DD<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<DD<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public DD<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<DD<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public DD<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public DD<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<DD<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public DD<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public DD<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<DD<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public DD<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public DD<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<DD<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public DD<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public DD<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<DD<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<DD<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<DD<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<DD<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<DD<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<DD<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<DD<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<DD<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<DD<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<DD<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public DD<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public DD<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<DD<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public DD<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public DD<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<DD<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public DD<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public DD<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<DD<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public DD<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public DD<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public DD<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<DD<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public DD<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<DD<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public DD<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public DD<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<DD<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public DD<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public DD<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<DD<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public DD<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public DD<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public DD<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<DD<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public DD<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<DD<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public DD<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public DD<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<DD<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public DD<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public DD<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<DD<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public DD<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public DD<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<DD<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public DD<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public DD<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<DD<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<DD<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public DD<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public DD<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<DD<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public DD<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<DD<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<DD<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<DD<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public DD<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public DD<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<DD<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public DD<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public DD<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<DD<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<DD<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public DD<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public DD<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<DD<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<DD<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public DD<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<DD<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public DD<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<DD<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public DD<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public DD<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<DD<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public DD<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<DD<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public DD<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<DD<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public DD<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<DD<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public DD<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<DD<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<DD<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<DD<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<DD<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<DD<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<DD<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public DD<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<DD<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<DD<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public DD<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class DT<T extends _> extends EImp<T> implements HamletSpec.DT {
    public DT(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public DT<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public DT<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public DT<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public DT<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public DT<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public DT<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public DT<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public DT<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public DT<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public DT<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public DT<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public DT<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public DT<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public DT<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public DT<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public DT<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public DT<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public DT<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<DT<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public DT<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public DT<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<DT<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public DT<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public DT<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<DT<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public DT<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public DT<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public DT<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<DT<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public DT<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<DT<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public DT<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public DT<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<DT<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public DT<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public DT<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<DT<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public DT<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public DT<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public DT<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<DT<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public DT<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<DT<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public DT<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public DT<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<DT<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public DT<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public DT<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<DT<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public DT<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public DT<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<DT<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public DT<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public DT<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<DT<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<DT<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public DT<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public DT<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<DT<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public DT<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<DT<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<DT<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<DT<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public DT<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public DT<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<DT<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public DT<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public DT<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<DT<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<DT<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public DT<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public DT<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<DT<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<DT<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public DT<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<DT<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public DT<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<DT<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public DT<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public DT<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<DT<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public DT<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<DT<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public DT<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<DT<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public DT<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<DT<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public DT<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<DT<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<DT<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<DT<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<DT<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<DT<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<DT<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public DT<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<DT<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<DT<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public DT<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class DL<T extends _> extends EImp<T> implements HamletSpec.DL {
    public DL(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public DL<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public DL<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public DL<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public DL<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public DL<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public DL<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public DL<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public DL<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public DL<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public DL<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public DL<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public DL<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public DL<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public DL<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public DL<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public DL<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public DT<DL<T>> dt() {
      closeAttrs();
      return dt_(this, false);
    }

    
    public DL<T> dt(String cdata) {
      return dt()._(cdata)._();
    }

    
    public DD<DL<T>> dd() {
      closeAttrs();
      return dd_(this, false);
    }

    
    public DL<T> dd(String cdata) {
      return dd()._(cdata)._();
    }
  }

  private <T extends _> DT<T> dt_(T e, boolean inline) {
    return new DT<T>("dt", e, opt(false, inline, false)); }

  private <T extends _> DD<T> dd_(T e, boolean inline) {
    return new DD<T>("dd", e, opt(false, inline, false)); }

  public class DEL<T extends _> extends EImp<T> implements HamletSpec.DEL {
    public DEL(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public DEL<T> $cite(String value) {
      addAttr("cite", value);
      return this;
    }

    
    public DEL<T> $datetime(String value) {
      addAttr("datetime", value);
      return this;
    }

    
    public DEL<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public DEL<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public DEL<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public DEL<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public DEL<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public DEL<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public DEL<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public DEL<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public DEL<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public DEL<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public DEL<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public DEL<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public DEL<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public DEL<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public DEL<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public DEL<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<DEL<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<DEL<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public DEL<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<DEL<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<DEL<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<DEL<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public DEL<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<DEL<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public DEL<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<DEL<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<DEL<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<DEL<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<DEL<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<DEL<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<DEL<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public DEL<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<DEL<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public DEL<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public DEL<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<DEL<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public DEL<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<DEL<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public DEL<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public DEL<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<DEL<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public DEL<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public DEL<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<DEL<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public DEL<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public DEL<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<DEL<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public DEL<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public DEL<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<DEL<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<DEL<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<DEL<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<DEL<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<DEL<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<DEL<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<DEL<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<DEL<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<DEL<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<DEL<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public DEL<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public DEL<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<DEL<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public DEL<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public DEL<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<DEL<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public DEL<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public DEL<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<DEL<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public DEL<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public DEL<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public DEL<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<DEL<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public DEL<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<DEL<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public DEL<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public DEL<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<DEL<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public DEL<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public DEL<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<DEL<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public DEL<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public DEL<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public DEL<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<DEL<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public DEL<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<DEL<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public DEL<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public DEL<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<DEL<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public DEL<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public DEL<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<DEL<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public DEL<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public DEL<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<DEL<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public DEL<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public DEL<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<DEL<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<DEL<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public DEL<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public DEL<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<DEL<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public DEL<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<DEL<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<DEL<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<DEL<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public DEL<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public DEL<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<DEL<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public DEL<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public DEL<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<DEL<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<DEL<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public DEL<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public DEL<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<DEL<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<DEL<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public DEL<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<DEL<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public DEL<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<DEL<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public DEL<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public DEL<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<DEL<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public DEL<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<DEL<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public DEL<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<DEL<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public DEL<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<DEL<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public DEL<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<DEL<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<DEL<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<DEL<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<DEL<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<DEL<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<DEL<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public DEL<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<DEL<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<DEL<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public DEL<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class INS<T extends _> extends EImp<T> implements HamletSpec.INS {
    public INS(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public INS<T> $cite(String value) {
      addAttr("cite", value);
      return this;
    }

    
    public INS<T> $datetime(String value) {
      addAttr("datetime", value);
      return this;
    }

    
    public INS<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public INS<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public INS<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public INS<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public INS<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public INS<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public INS<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public INS<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public INS<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public INS<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public INS<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public INS<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public INS<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public INS<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public INS<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public INS<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<INS<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<INS<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public INS<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<INS<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<INS<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<INS<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public INS<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<INS<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public INS<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<INS<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<INS<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<INS<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<INS<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<INS<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<INS<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public INS<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<INS<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public INS<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public INS<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<INS<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public INS<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<INS<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public INS<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public INS<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<INS<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public INS<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public INS<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<INS<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public INS<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public INS<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<INS<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public INS<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public INS<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<INS<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<INS<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<INS<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<INS<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<INS<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<INS<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<INS<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<INS<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<INS<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<INS<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public INS<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public INS<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<INS<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public INS<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public INS<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<INS<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public INS<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public INS<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<INS<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public INS<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public INS<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public INS<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<INS<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public INS<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<INS<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public INS<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public INS<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<INS<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public INS<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public INS<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<INS<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public INS<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public INS<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public INS<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<INS<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public INS<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<INS<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public INS<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public INS<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<INS<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public INS<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public INS<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<INS<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public INS<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public INS<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<INS<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public INS<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public INS<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<INS<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<INS<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public INS<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public INS<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<INS<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public INS<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<INS<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<INS<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<INS<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public INS<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public INS<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<INS<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public INS<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public INS<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<INS<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<INS<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public INS<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public INS<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<INS<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<INS<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public INS<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<INS<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public INS<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<INS<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public INS<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public INS<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<INS<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public INS<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<INS<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public INS<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<INS<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public INS<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<INS<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public INS<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<INS<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<INS<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<INS<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<INS<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<INS<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<INS<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public INS<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<INS<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<INS<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public INS<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class BLOCKQUOTE<T extends _> extends EImp<T> implements HamletSpec.BLOCKQUOTE {
    public BLOCKQUOTE(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public BLOCKQUOTE<T> $cite(String value) {
      addAttr("cite", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public BLOCKQUOTE<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<BLOCKQUOTE<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<BLOCKQUOTE<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public BLOCKQUOTE<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<BLOCKQUOTE<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<BLOCKQUOTE<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<BLOCKQUOTE<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public BLOCKQUOTE<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<BLOCKQUOTE<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public BLOCKQUOTE<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<BLOCKQUOTE<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<BLOCKQUOTE<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<BLOCKQUOTE<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<BLOCKQUOTE<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<BLOCKQUOTE<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<BLOCKQUOTE<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<BLOCKQUOTE<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public BLOCKQUOTE<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public BLOCKQUOTE<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<BLOCKQUOTE<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public BLOCKQUOTE<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<BLOCKQUOTE<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public BLOCKQUOTE<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public BLOCKQUOTE<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<BLOCKQUOTE<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public BLOCKQUOTE<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public BLOCKQUOTE<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<BLOCKQUOTE<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public BLOCKQUOTE<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public BLOCKQUOTE<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<BLOCKQUOTE<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public BLOCKQUOTE<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public BLOCKQUOTE<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<BLOCKQUOTE<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<BLOCKQUOTE<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<BLOCKQUOTE<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<BLOCKQUOTE<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<BLOCKQUOTE<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<BLOCKQUOTE<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<BLOCKQUOTE<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<BLOCKQUOTE<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<BLOCKQUOTE<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<BLOCKQUOTE<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public SCRIPT<BLOCKQUOTE<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public BLOCKQUOTE<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }
  }

  public class Q<T extends _> extends EImp<T> implements HamletSpec.Q {
    public Q(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public Q<T> $cite(String value) {
      addAttr("cite", value);
      return this;
    }

    
    public Q<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public Q<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public Q<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public Q<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public Q<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public Q<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public Q<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public Q<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public Q<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public Q<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public Q<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public Q<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public Q<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public Q<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public Q<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public Q<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public Q<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public Q<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<Q<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public Q<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public Q<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<Q<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public Q<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public Q<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<Q<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public Q<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public Q<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public Q<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<Q<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public Q<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<Q<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public Q<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public Q<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<Q<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public Q<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public Q<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<Q<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public Q<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public Q<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public Q<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<Q<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public Q<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<Q<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public Q<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public Q<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<Q<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public Q<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public Q<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<Q<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public Q<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public Q<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<Q<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public Q<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public Q<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<Q<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<Q<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public Q<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public Q<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<Q<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public Q<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<Q<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<Q<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<Q<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public Q<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public Q<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<Q<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public Q<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public Q<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<Q<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<Q<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public Q<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public Q<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<Q<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<Q<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public Q<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<Q<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public Q<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<Q<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public Q<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public Q<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<Q<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public Q<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<Q<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public Q<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<Q<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public Q<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<Q<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public Q<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<Q<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<Q<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<Q<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<Q<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<Q<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<Q<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public Q<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<Q<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<Q<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public Q<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class PRE<T extends _> extends EImp<T> implements HamletSpec.PRE {
    public PRE(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public PRE<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public PRE<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public PRE<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public PRE<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public PRE<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public PRE<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public PRE<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public PRE<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public PRE<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public PRE<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public PRE<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public PRE<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public PRE<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public PRE<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public PRE<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public PRE<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public PRE<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public PRE<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<PRE<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public PRE<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public PRE<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<PRE<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public PRE<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public PRE<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public PRE<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<PRE<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public PRE<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<PRE<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public PRE<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public PRE<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<PRE<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public PRE<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public PRE<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<PRE<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public PRE<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public PRE<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public PRE<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<PRE<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public PRE<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<PRE<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public PRE<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public PRE<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<PRE<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public PRE<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public PRE<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<PRE<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public PRE<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public PRE<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<PRE<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public PRE<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public PRE<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<PRE<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<PRE<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public PRE<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public PRE<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public MAP<PRE<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<PRE<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public PRE<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public PRE<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<PRE<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<PRE<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public PRE<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<PRE<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public PRE<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<PRE<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public PRE<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public PRE<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<PRE<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public PRE<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<PRE<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public PRE<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<PRE<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public PRE<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<PRE<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public PRE<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<PRE<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<PRE<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<PRE<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<PRE<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<PRE<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<PRE<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public PRE<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<PRE<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<PRE<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public PRE<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class H6<T extends _> extends EImp<T> implements HamletSpec.H6 {
    public H6(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public H6<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public H6<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public H6<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public H6<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public H6<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public H6<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public H6<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public H6<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public H6<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public H6<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public H6<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public H6<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public H6<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public H6<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public H6<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public H6<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public H6<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public H6<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<H6<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public H6<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public H6<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<H6<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public H6<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public H6<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<H6<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public H6<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public H6<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public H6<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<H6<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public H6<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<H6<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public H6<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public H6<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<H6<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public H6<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public H6<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<H6<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public H6<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public H6<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public H6<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<H6<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public H6<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<H6<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public H6<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public H6<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<H6<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public H6<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public H6<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<H6<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public H6<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public H6<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<H6<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public H6<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public H6<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<H6<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<H6<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public H6<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public H6<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<H6<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public H6<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<H6<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<H6<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<H6<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public H6<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public H6<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<H6<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public H6<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public H6<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<H6<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<H6<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public H6<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public H6<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<H6<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<H6<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public H6<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<H6<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public H6<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<H6<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public H6<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public H6<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<H6<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public H6<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<H6<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public H6<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<H6<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public H6<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<H6<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public H6<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<H6<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<H6<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<H6<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<H6<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<H6<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<H6<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public H6<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<H6<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<H6<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public H6<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class H5<T extends _> extends EImp<T> implements HamletSpec.H5 {
    public H5(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public H5<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public H5<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public H5<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public H5<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public H5<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public H5<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public H5<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public H5<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public H5<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public H5<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public H5<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public H5<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public H5<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public H5<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public H5<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public H5<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public H5<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public H5<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<H5<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public H5<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public H5<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<H5<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public H5<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public H5<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<H5<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public H5<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public H5<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public H5<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<H5<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public H5<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<H5<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public H5<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public H5<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<H5<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public H5<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public H5<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<H5<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public H5<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public H5<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public H5<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<H5<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public H5<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<H5<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public H5<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public H5<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<H5<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public H5<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public H5<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<H5<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public H5<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public H5<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<H5<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public H5<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public H5<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<H5<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<H5<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public H5<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public H5<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<H5<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public H5<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<H5<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<H5<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<H5<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public H5<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public H5<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<H5<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public H5<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public H5<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<H5<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<H5<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public H5<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public H5<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<H5<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<H5<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public H5<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<H5<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public H5<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<H5<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public H5<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public H5<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<H5<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public H5<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<H5<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public H5<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<H5<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public H5<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<H5<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public H5<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<H5<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<H5<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<H5<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<H5<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<H5<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<H5<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public H5<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<H5<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<H5<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public H5<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class H4<T extends _> extends EImp<T> implements HamletSpec.H4 {
    public H4(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public H4<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public H4<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public H4<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public H4<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public H4<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public H4<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public H4<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public H4<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public H4<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public H4<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public H4<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public H4<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public H4<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public H4<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public H4<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public H4<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public H4<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public H4<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<H4<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public H4<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public H4<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<H4<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public H4<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public H4<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<H4<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public H4<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public H4<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public H4<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<H4<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public H4<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<H4<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public H4<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public H4<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<H4<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public H4<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public H4<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<H4<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public H4<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public H4<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public H4<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<H4<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public H4<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<H4<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public H4<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public H4<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<H4<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public H4<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public H4<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<H4<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public H4<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public H4<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<H4<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public H4<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public H4<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<H4<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<H4<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public H4<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public H4<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<H4<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public H4<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<H4<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<H4<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<H4<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public H4<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public H4<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<H4<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public H4<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public H4<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<H4<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<H4<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public H4<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public H4<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<H4<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<H4<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public H4<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<H4<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public H4<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<H4<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public H4<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public H4<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<H4<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public H4<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<H4<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public H4<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<H4<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public H4<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<H4<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public H4<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<H4<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<H4<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<H4<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<H4<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<H4<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<H4<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public H4<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<H4<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<H4<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public H4<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class H3<T extends _> extends EImp<T> implements HamletSpec.H3 {
    public H3(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public H3<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public H3<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public H3<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public H3<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public H3<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public H3<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public H3<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public H3<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public H3<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public H3<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public H3<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public H3<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public H3<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public H3<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public H3<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public H3<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public H3<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public H3<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<H3<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public H3<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public H3<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<H3<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public H3<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public H3<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<H3<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public H3<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public H3<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public H3<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<H3<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public H3<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<H3<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public H3<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public H3<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<H3<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public H3<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public H3<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<H3<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public H3<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public H3<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public H3<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<H3<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public H3<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<H3<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public H3<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public H3<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<H3<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public H3<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public H3<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<H3<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public H3<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public H3<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<H3<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public H3<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public H3<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<H3<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<H3<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public H3<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public H3<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<H3<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public H3<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<H3<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<H3<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<H3<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public H3<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public H3<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<H3<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public H3<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public H3<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<H3<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<H3<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public H3<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public H3<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<H3<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<H3<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public H3<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<H3<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public H3<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<H3<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public H3<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public H3<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<H3<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public H3<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<H3<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public H3<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<H3<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public H3<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<H3<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public H3<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<H3<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<H3<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<H3<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<H3<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<H3<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<H3<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public H3<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<H3<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<H3<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public H3<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class H2<T extends _> extends EImp<T> implements HamletSpec.H2 {
    public H2(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public H2<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public H2<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public H2<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public H2<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public H2<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public H2<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public H2<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public H2<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public H2<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public H2<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public H2<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public H2<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public H2<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public H2<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public H2<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public H2<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public H2<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public H2<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<H2<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public H2<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public H2<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<H2<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public H2<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public H2<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<H2<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public H2<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public H2<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public H2<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<H2<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public H2<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<H2<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public H2<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public H2<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<H2<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public H2<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public H2<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<H2<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public H2<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public H2<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public H2<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<H2<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public H2<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<H2<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public H2<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public H2<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<H2<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public H2<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public H2<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<H2<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public H2<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public H2<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<H2<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public H2<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public H2<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<H2<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<H2<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public H2<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public H2<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<H2<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public H2<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<H2<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<H2<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<H2<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public H2<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public H2<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<H2<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public H2<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public H2<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<H2<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<H2<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public H2<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public H2<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<H2<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<H2<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public H2<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<H2<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public H2<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<H2<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public H2<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public H2<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<H2<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public H2<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<H2<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public H2<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<H2<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public H2<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<H2<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public H2<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<H2<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<H2<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<H2<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<H2<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<H2<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<H2<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public H2<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<H2<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<H2<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public H2<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class H1<T extends _> extends EImp<T> implements HamletSpec.H1 {
    public H1(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public H1<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public H1<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public H1<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public H1<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public H1<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public H1<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public H1<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public H1<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public H1<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public H1<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public H1<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public H1<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public H1<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public H1<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public H1<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public H1<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public H1<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public H1<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<H1<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public H1<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public H1<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<H1<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public H1<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public H1<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<H1<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public H1<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public H1<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public H1<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<H1<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public H1<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<H1<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public H1<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public H1<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<H1<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public H1<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public H1<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<H1<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public H1<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public H1<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public H1<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<H1<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public H1<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<H1<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public H1<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public H1<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<H1<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public H1<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public H1<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<H1<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public H1<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public H1<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<H1<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public H1<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public H1<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<H1<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<H1<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public H1<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public H1<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<H1<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public H1<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<H1<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<H1<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<H1<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public H1<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public H1<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<H1<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public H1<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public H1<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<H1<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<H1<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public H1<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public H1<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<H1<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<H1<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public H1<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<H1<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public H1<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<H1<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public H1<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public H1<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<H1<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public H1<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<H1<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public H1<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<H1<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public H1<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<H1<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public H1<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<H1<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<H1<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<H1<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<H1<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<H1<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<H1<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public H1<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<H1<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<H1<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public H1<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class P<T extends _> extends EImp<T> implements HamletSpec.P {
    public P(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public P<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public P<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public P<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public P<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public P<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public P<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public P<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public P<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public P<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public P<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public P<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public P<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public P<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public P<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public P<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public P<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public P<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public P<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<P<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public P<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public P<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<P<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public P<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public P<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<P<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public P<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public P<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public P<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<P<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public P<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<P<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public P<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public P<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<P<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public P<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public P<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<P<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public P<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public P<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public P<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<P<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public P<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<P<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public P<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public P<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<P<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public P<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public P<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<P<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public P<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public P<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<P<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public P<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public P<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<P<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<P<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public P<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public P<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<P<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public P<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<P<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<P<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<P<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public P<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public P<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<P<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public P<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public P<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<P<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<P<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public P<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public P<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<P<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<P<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public P<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<P<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public P<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<P<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public P<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public P<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<P<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public P<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<P<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public P<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<P<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public P<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<P<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public P<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<P<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<P<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<P<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<P<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<P<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<P<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public P<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<P<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<P<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public P<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class HR<T extends _> extends EImp<T> implements HamletSpec.HR {
    public HR(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public HR<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public HR<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public HR<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public HR<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public HR<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public HR<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public HR<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public HR<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public HR<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public HR<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public HR<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public HR<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public HR<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public HR<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public HR<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public HR<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }
  }

  public class PARAM<T extends _> extends EImp<T> implements HamletSpec.PARAM {
    public PARAM(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public PARAM<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public PARAM<T> $name(String value) {
      addAttr("name", value);
      return this;
    }

    
    public PARAM<T> $value(String value) {
      addAttr("value", value);
      return this;
    }
  }

  public class OBJECT<T extends _> extends EImp<T> implements HamletSpec.OBJECT {
    public OBJECT(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public OBJECT<T> $type(String value) {
      addAttr("type", value);
      return this;
    }

    
    public OBJECT<T> $name(String value) {
      addAttr("name", value);
      return this;
    }

    
    public OBJECT<T> $tabindex(int value) {
      addAttr("tabindex", value);
      return this;
    }

    
    public OBJECT<T> $data(String value) {
      addAttr("data", value);
      return this;
    }

    
    public OBJECT<T> $height(String value) {
      addAttr("height", value);
      return this;
    }

    
    public OBJECT<T> $height(int value) {
      addAttr("height", value);
      return this;
    }

    
    public OBJECT<T> $width(int value) {
      addAttr("width", value);
      return this;
    }

    
    public OBJECT<T> $width(String value) {
      addAttr("width", value);
      return this;
    }

    
    public OBJECT<T> $usemap(String value) {
      addAttr("usemap", value);
      return this;
    }

    
    public OBJECT<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public OBJECT<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public OBJECT<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public OBJECT<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public OBJECT<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public OBJECT<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public OBJECT<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public OBJECT<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public OBJECT<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public OBJECT<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public OBJECT<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public OBJECT<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public OBJECT<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public OBJECT<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public OBJECT<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public OBJECT<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public PARAM<OBJECT<T>> param() {
      closeAttrs();
      return param_(this, false);
    }

    
    public OBJECT<T> param(String name, String value) {
      return param().$name(name).$value(value)._();
    }

    
    public TABLE<OBJECT<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<OBJECT<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public OBJECT<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<OBJECT<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<OBJECT<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<OBJECT<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public OBJECT<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<OBJECT<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public OBJECT<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<OBJECT<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<OBJECT<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<OBJECT<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<OBJECT<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<OBJECT<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<OBJECT<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public OBJECT<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<OBJECT<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public OBJECT<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public OBJECT<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<OBJECT<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public OBJECT<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<OBJECT<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public OBJECT<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public OBJECT<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<OBJECT<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public OBJECT<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public OBJECT<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<OBJECT<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public OBJECT<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public OBJECT<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<OBJECT<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public OBJECT<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public OBJECT<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<OBJECT<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<OBJECT<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<OBJECT<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<OBJECT<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<OBJECT<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<OBJECT<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<OBJECT<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<OBJECT<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<OBJECT<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<OBJECT<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public OBJECT<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public OBJECT<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<OBJECT<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public OBJECT<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public OBJECT<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<OBJECT<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public OBJECT<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public OBJECT<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<OBJECT<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public OBJECT<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public OBJECT<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public OBJECT<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<OBJECT<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public OBJECT<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<OBJECT<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public OBJECT<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public OBJECT<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<OBJECT<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public OBJECT<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public OBJECT<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<OBJECT<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public OBJECT<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public OBJECT<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public OBJECT<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<OBJECT<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public OBJECT<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<OBJECT<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public OBJECT<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public OBJECT<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<OBJECT<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public OBJECT<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public OBJECT<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<OBJECT<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public OBJECT<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public OBJECT<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<OBJECT<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public OBJECT<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public OBJECT<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<OBJECT<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<OBJECT<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public OBJECT<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public OBJECT<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<OBJECT<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public OBJECT<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<OBJECT<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<OBJECT<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<OBJECT<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public OBJECT<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public OBJECT<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<OBJECT<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public OBJECT<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public OBJECT<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<OBJECT<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<OBJECT<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public OBJECT<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public OBJECT<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<OBJECT<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<OBJECT<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public OBJECT<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<OBJECT<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public OBJECT<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<OBJECT<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public OBJECT<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public OBJECT<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<OBJECT<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public OBJECT<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<OBJECT<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public OBJECT<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<OBJECT<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public OBJECT<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<OBJECT<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public OBJECT<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<OBJECT<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<OBJECT<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<OBJECT<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<OBJECT<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<OBJECT<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<OBJECT<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public OBJECT<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<OBJECT<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<OBJECT<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public OBJECT<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  private <T extends _> PARAM<T> param_(T e, boolean inline) {
    return new PARAM<T>("param", e, opt(false, inline, false)); }

  public class IMG<T extends _> extends EImp<T> implements HamletSpec.IMG {
    public IMG(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public IMG<T> $src(String value) {
      addAttr("src", value);
      return this;
    }

    
    public IMG<T> $alt(String value) {
      addAttr("alt", value);
      return this;
    }

    
    public IMG<T> $ismap() {
      addAttr("ismap", null);
      return this;
    }

    
    public IMG<T> $height(String value) {
      addAttr("height", value);
      return this;
    }

    
    public IMG<T> $height(int value) {
      addAttr("height", value);
      return this;
    }

    
    public IMG<T> $width(int value) {
      addAttr("width", value);
      return this;
    }

    
    public IMG<T> $width(String value) {
      addAttr("width", value);
      return this;
    }

    
    public IMG<T> $usemap(String value) {
      addAttr("usemap", value);
      return this;
    }

    
    public IMG<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public IMG<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public IMG<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public IMG<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public IMG<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public IMG<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public IMG<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public IMG<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public IMG<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public IMG<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public IMG<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public IMG<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public IMG<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public IMG<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public IMG<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public IMG<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }
  }

  public class LINK<T extends _> extends EImp<T> implements HamletSpec.LINK {
    public LINK(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public LINK<T> $rel(EnumSet<LinkType> value) {
      addRelAttr("rel", value);
      return this;
    }

    
    public LINK<T> $rel(String value) {
      addAttr("rel", value);
      return this;
    }

    
    public LINK<T> $href(String value) {
      addAttr("href", value);
      return this;
    }

    
    public LINK<T> $type(String value) {
      addAttr("type", value);
      return this;
    }

    
    public LINK<T> $media(EnumSet<Media> value) {
      addMediaAttr("media", value);
      return this;
    }

    
    public LINK<T> $media(String value) {
      addAttr("media", value);
      return this;
    }

    
    public LINK<T> $hreflang(String value) {
      addAttr("hreflang", value);
      return this;
    }

    
    public LINK<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public LINK<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public LINK<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public LINK<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public LINK<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public LINK<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public LINK<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public LINK<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public LINK<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public LINK<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public LINK<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public LINK<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public LINK<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public LINK<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public LINK<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public LINK<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }
  }

  public class AREA<T extends _> extends EImp<T> implements HamletSpec.AREA {
    public AREA(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public AREA<T> $href(String value) {
      addAttr("href", value);
      return this;
    }

    
    public AREA<T> $tabindex(int value) {
      addAttr("tabindex", value);
      return this;
    }

    
    public AREA<T> $accesskey(String value) {
      addAttr("accesskey", value);
      return this;
    }

    
    public AREA<T> $onfocus(String value) {
      addAttr("onfocus", value);
      return this;
    }

    
    public AREA<T> $onblur(String value) {
      addAttr("onblur", value);
      return this;
    }

    
    public AREA<T> $alt(String value) {
      addAttr("alt", value);
      return this;
    }

    
    public AREA<T> $shape(Shape value) {
      addAttr("shape", value);
      return this;
    }

    
    public AREA<T> $coords(String value) {
      addAttr("coords", value);
      return this;
    }

    
    public AREA<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public AREA<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public AREA<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public AREA<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public AREA<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public AREA<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public AREA<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public AREA<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public AREA<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public AREA<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public AREA<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public AREA<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public AREA<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public AREA<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public AREA<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public AREA<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }
  }

  private <T extends _> AREA<T> area_(T e, boolean inline) {
    return new AREA<T>("area", e, opt(false, inline, false)); }

  public class MAP<T extends _> extends EImp<T> implements HamletSpec.MAP {
    public MAP(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public MAP<T> $name(String value) {
      addAttr("name", value);
      return this;
    }

    
    public AREA<MAP<T>> area() {
      closeAttrs();
      return area_(this, false);
    }

    
    public AREA<MAP<T>> area(String selector) {
      return setSelector(area(), selector);
    }

    
    public MAP<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public MAP<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public MAP<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public MAP<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public MAP<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public MAP<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public MAP<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public MAP<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public MAP<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public MAP<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public MAP<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public MAP<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public MAP<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public MAP<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public MAP<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public MAP<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<MAP<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<MAP<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public MAP<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<MAP<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<MAP<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<MAP<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public MAP<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<MAP<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public MAP<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<MAP<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<MAP<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<MAP<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<MAP<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<MAP<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<MAP<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public MAP<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<MAP<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public MAP<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public MAP<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<MAP<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public MAP<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<MAP<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public MAP<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public MAP<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<MAP<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public MAP<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public MAP<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<MAP<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public MAP<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public MAP<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<MAP<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public MAP<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public MAP<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<MAP<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<MAP<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<MAP<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<MAP<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<MAP<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<MAP<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<MAP<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<MAP<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<MAP<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<MAP<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }
  }

  public class A<T extends _> extends EImp<T> implements HamletSpec.A {
    public A(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public A<T> $rel(EnumSet<LinkType> value) {
      addRelAttr("rel", value);
      return this;
    }

    
    public A<T> $rel(String value) {
      addAttr("rel", value);
      return this;
    }

    
    public A<T> $href(String value) {
      addAttr("href", value);
      return this;
    }

    
    public A<T> $type(String value) {
      addAttr("type", value);
      return this;
    }

    
    public A<T> $tabindex(int value) {
      addAttr("tabindex", value);
      return this;
    }

    
    public A<T> $accesskey(String value) {
      addAttr("accesskey", value);
      return this;
    }

    
    public A<T> $onfocus(String value) {
      addAttr("onfocus", value);
      return this;
    }

    
    public A<T> $onblur(String value) {
      addAttr("onblur", value);
      return this;
    }

    
    public A<T> $hreflang(String value) {
      addAttr("hreflang", value);
      return this;
    }

    
    public A<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public A<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public A<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public A<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public A<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public A<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public A<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public A<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public A<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public A<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public A<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public A<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public A<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public A<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public A<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public A<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public A<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public A<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<A<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public A<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public A<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<A<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public A<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public A<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<A<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public A<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public A<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public A<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<A<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public A<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<A<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public A<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public A<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<A<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public A<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public A<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<A<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public A<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public A<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public A<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<A<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public A<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<A<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public A<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public A<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<A<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public A<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public A<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<A<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public A<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public A<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<A<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public A<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public A<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public IMG<A<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public A<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<A<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<A<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public MAP<A<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<A<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public A<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public A<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<A<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<A<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public A<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<A<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public A<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<A<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public A<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public A<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<A<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public A<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<A<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public A<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<A<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public A<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public SUB<A<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public A<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public A<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<A<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public A<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public A<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public LABEL<A<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public A<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<A<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<A<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<A<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<A<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<A<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<A<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public A<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<A<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<A<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public A<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class DIV<T extends _> extends EImp<T> implements HamletSpec.DIV {
    public DIV(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public DIV<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public DIV<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public DIV<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public DIV<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public DIV<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public DIV<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public DIV<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public DIV<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public DIV<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public DIV<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public DIV<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public DIV<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public DIV<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public DIV<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public DIV<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public DIV<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<DIV<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<DIV<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public DIV<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<DIV<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<DIV<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<DIV<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public DIV<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<DIV<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public DIV<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<DIV<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<DIV<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<DIV<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<DIV<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<DIV<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<DIV<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public DIV<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<DIV<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public DIV<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public DIV<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<DIV<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public DIV<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<DIV<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public DIV<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public DIV<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<DIV<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public DIV<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public DIV<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<DIV<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public DIV<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public DIV<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<DIV<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public DIV<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public DIV<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<DIV<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<DIV<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<DIV<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<DIV<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<DIV<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<DIV<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<DIV<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<DIV<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<DIV<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<DIV<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public DIV<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public DIV<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<DIV<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public DIV<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public DIV<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<DIV<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public DIV<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public DIV<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<DIV<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public DIV<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public DIV<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public DIV<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<DIV<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public DIV<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<DIV<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public DIV<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public DIV<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<DIV<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public DIV<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public DIV<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<DIV<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public DIV<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public DIV<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public DIV<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<DIV<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public DIV<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<DIV<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public DIV<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public DIV<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<DIV<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public DIV<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public DIV<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<DIV<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public DIV<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public DIV<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<DIV<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public DIV<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public DIV<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<DIV<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<DIV<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public DIV<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public DIV<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<DIV<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public DIV<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<DIV<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<DIV<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<DIV<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public DIV<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public DIV<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<DIV<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public DIV<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public DIV<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<DIV<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<DIV<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public DIV<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public DIV<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<DIV<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<DIV<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public DIV<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<DIV<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public DIV<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<DIV<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public DIV<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public DIV<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<DIV<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public DIV<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<DIV<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public DIV<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<DIV<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public DIV<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<DIV<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public DIV<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<DIV<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<DIV<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<DIV<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<DIV<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<DIV<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<DIV<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public DIV<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<DIV<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<DIV<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public DIV<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class ADDRESS<T extends _> extends EImp<T> implements HamletSpec.ADDRESS {
    public ADDRESS(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public ADDRESS<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public ADDRESS<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public ADDRESS<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public ADDRESS<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public ADDRESS<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public ADDRESS<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public ADDRESS<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public ADDRESS<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public ADDRESS<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public ADDRESS<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public ADDRESS<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public ADDRESS<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public ADDRESS<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public ADDRESS<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public ADDRESS<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public ADDRESS<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public ADDRESS<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public ADDRESS<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<ADDRESS<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public ADDRESS<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public ADDRESS<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<ADDRESS<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public ADDRESS<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public ADDRESS<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<ADDRESS<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public ADDRESS<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public ADDRESS<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public ADDRESS<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<ADDRESS<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public ADDRESS<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<ADDRESS<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public ADDRESS<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public ADDRESS<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<ADDRESS<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public ADDRESS<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public ADDRESS<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<ADDRESS<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public ADDRESS<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public ADDRESS<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public ADDRESS<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<ADDRESS<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public ADDRESS<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<ADDRESS<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public ADDRESS<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public ADDRESS<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<ADDRESS<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public ADDRESS<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public ADDRESS<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<ADDRESS<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public ADDRESS<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public ADDRESS<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<ADDRESS<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public ADDRESS<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public ADDRESS<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<ADDRESS<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<ADDRESS<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public ADDRESS<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public ADDRESS<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<ADDRESS<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public ADDRESS<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<ADDRESS<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<ADDRESS<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<ADDRESS<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public ADDRESS<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public ADDRESS<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<ADDRESS<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public ADDRESS<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public ADDRESS<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<ADDRESS<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<ADDRESS<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public ADDRESS<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public ADDRESS<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<ADDRESS<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<ADDRESS<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public ADDRESS<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<ADDRESS<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public ADDRESS<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<ADDRESS<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public ADDRESS<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public ADDRESS<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<ADDRESS<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public ADDRESS<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<ADDRESS<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public ADDRESS<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<ADDRESS<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public ADDRESS<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<ADDRESS<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public ADDRESS<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<ADDRESS<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<ADDRESS<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<ADDRESS<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<ADDRESS<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<ADDRESS<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<ADDRESS<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public ADDRESS<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<ADDRESS<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<ADDRESS<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public ADDRESS<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class BODY<T extends _> extends EImp<T> implements HamletSpec.BODY {
    public BODY(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public BODY<T> $onload(String value) {
      addAttr("onload", value);
      return this;
    }

    
    public BODY<T> $onunload(String value) {
      addAttr("onunload", value);
      return this;
    }

    
    public BODY<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public BODY<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public BODY<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public BODY<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public BODY<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public BODY<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public BODY<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public BODY<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public BODY<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public BODY<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public BODY<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public BODY<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public BODY<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public BODY<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public BODY<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public BODY<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public TABLE<BODY<T>> table() {
      closeAttrs();
      return table_(this, false);
    }

    
    public TABLE<BODY<T>> table(String selector) {
      return setSelector(table(), selector);
    }

    
    public BODY<T> address(String cdata) {
      return address()._(cdata)._();
    }

    
    public ADDRESS<BODY<T>> address() {
      closeAttrs();
      return address_(this, false);
    }

    
    public P<BODY<T>> p(String selector) {
      return setSelector(p(), selector);
    }

    
    public P<BODY<T>> p() {
      closeAttrs();
      return p_(this, false);
    }

    
    public BODY<T> _(Class<? extends SubView> cls) {
      _v(cls);
      return this;
    }

    
    public HR<BODY<T>> hr() {
      closeAttrs();
      return hr_(this, false);
    }

    
    public BODY<T> hr(String selector) {
      return setSelector(hr(), selector)._();
    }

    
    public DL<BODY<T>> dl(String selector) {
      return setSelector(dl(), selector);
    }

    
    public DL<BODY<T>> dl() {
      closeAttrs();
      return dl_(this, false);
    }

    
    public DIV<BODY<T>> div(String selector) {
      return setSelector(div(), selector);
    }

    
    public DIV<BODY<T>> div() {
      closeAttrs();
      return div_(this, false);
    }

    
    public BLOCKQUOTE<BODY<T>> blockquote() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BLOCKQUOTE<BODY<T>> bq() {
      closeAttrs();
      return blockquote_(this, false);
    }

    
    public BODY<T> h1(String cdata) {
      return h1()._(cdata)._();
    }

    
    public H1<BODY<T>> h1() {
      closeAttrs();
      return h1_(this, false);
    }

    
    public BODY<T> h1(String selector, String cdata) {
      return setSelector(h1(), selector)._(cdata)._();
    }

    
    public BODY<T> h2(String cdata) {
      return h2()._(cdata)._();
    }

    
    public H2<BODY<T>> h2() {
      closeAttrs();
      return h2_(this, false);
    }

    
    public BODY<T> h2(String selector, String cdata) {
      return setSelector(h2(), selector)._(cdata)._();
    }

    
    public H3<BODY<T>> h3() {
      closeAttrs();
      return h3_(this, false);
    }

    
    public BODY<T> h3(String cdata) {
      return h3()._(cdata)._();
    }

    
    public BODY<T> h3(String selector, String cdata) {
      return setSelector(h3(), selector)._(cdata)._();
    }

    
    public H4<BODY<T>> h4() {
      closeAttrs();
      return h4_(this, false);
    }

    
    public BODY<T> h4(String cdata) {
      return h4()._(cdata)._();
    }

    
    public BODY<T> h4(String selector, String cdata) {
      return setSelector(h4(), selector)._(cdata)._();
    }

    
    public H5<BODY<T>> h5() {
      closeAttrs();
      return h5_(this, false);
    }

    
    public BODY<T> h5(String cdata) {
      return h5()._(cdata)._();
    }

    
    public BODY<T> h5(String selector, String cdata) {
      return setSelector(h5(), selector)._(cdata)._();
    }

    
    public H6<BODY<T>> h6() {
      closeAttrs();
      return h6_(this, false);
    }

    
    public BODY<T> h6(String cdata) {
      return h6()._(cdata)._();
    }

    
    public BODY<T> h6(String selector, String cdata) {
      return setSelector(h6(), selector)._(cdata)._();
    }

    
    public UL<BODY<T>> ul() {
      closeAttrs();
      return ul_(this, false);
    }

    
    public UL<BODY<T>> ul(String selector) {
      return setSelector(ul(), selector);
    }

    
    public OL<BODY<T>> ol() {
      closeAttrs();
      return ol_(this, false);
    }

    
    public OL<BODY<T>> ol(String selector) {
      return setSelector(ol(), selector);
    }

    
    public PRE<BODY<T>> pre() {
      closeAttrs();
      return pre_(this, false);
    }

    
    public PRE<BODY<T>> pre(String selector) {
      return setSelector(pre(), selector);
    }

    
    public FORM<BODY<T>> form() {
      closeAttrs();
      return form_(this, false);
    }

    
    public FORM<BODY<T>> form(String selector) {
      return setSelector(form(), selector);
    }

    
    public FIELDSET<BODY<T>> fieldset() {
      closeAttrs();
      return fieldset_(this, false);
    }

    
    public FIELDSET<BODY<T>> fieldset(String selector) {
      return setSelector(fieldset(), selector);
    }

    
    public SCRIPT<BODY<T>> script() {
      closeAttrs();
      return script_(this, false);
    }

    
    public BODY<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<BODY<T>> ins() {
      closeAttrs();
      return ins_(this, false);
    }

    
    public BODY<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<BODY<T>> del() {
      closeAttrs();
      return del_(this, false);
    }

    
    public BODY<T> del(String cdata) {
      return del()._(cdata)._();
    }
  }

  private <T extends _> TABLE<T> table_(T e, boolean inline) {
    return new TABLE<T>("table", e, opt(true, inline, false)); }

  private <T extends _> ADDRESS<T> address_(T e, boolean inline) {
    return new ADDRESS<T>("address", e, opt(true, inline, false)); }

  private <T extends _> P<T> p_(T e, boolean inline) {
    return new P<T>("p", e, opt(false, inline, false)); }

  private <T extends _> HR<T> hr_(T e, boolean inline) {
    return new HR<T>("hr", e, opt(false, inline, false)); }

  private <T extends _> DL<T> dl_(T e, boolean inline) {
    return new DL<T>("dl", e, opt(true, inline, false)); }

  private <T extends _> DIV<T> div_(T e, boolean inline) {
    return new DIV<T>("div", e, opt(true, inline, false)); }

  private <T extends _> BLOCKQUOTE<T> blockquote_(T e, boolean inline) {
    return new BLOCKQUOTE<T>("blockquote", e, opt(true, inline, false)); }

  private <T extends _> BLOCKQUOTE<T> bq_(T e, boolean inline) {
    return new BLOCKQUOTE<T>("blockquote", e, opt(true, inline, false)); }

  private <T extends _> FIELDSET<T> fieldset_(T e, boolean inline) {
    return new FIELDSET<T>("fieldset", e, opt(true, inline, false)); }

  private <T extends _> FORM<T> form_(T e, boolean inline) {
    return new FORM<T>("form", e, opt(true, inline, false)); }

  public class BR<T extends _> extends EImp<T> implements HamletSpec.BR {
    public BR(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public BR<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public BR<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public BR<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public BR<T> $style(String value) {
      addAttr("style", value);
      return this;
    }
  }

  public class BDO<T extends _> extends EImp<T> implements HamletSpec.BDO {
    public BDO(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public BDO<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public BDO<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public BDO<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public BDO<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public BDO<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public BDO<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public BDO<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public BDO<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<BDO<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public BDO<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public BDO<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<BDO<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public BDO<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public BDO<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<BDO<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public BDO<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public BDO<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public BDO<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<BDO<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public BDO<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<BDO<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public BDO<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public BDO<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<BDO<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public BDO<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public BDO<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<BDO<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public BDO<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public BDO<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public BDO<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<BDO<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public BDO<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<BDO<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public BDO<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public BDO<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<BDO<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public BDO<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public BDO<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<BDO<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public BDO<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public BDO<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<BDO<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public BDO<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public BDO<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<BDO<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<BDO<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public BDO<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public BDO<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<BDO<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public BDO<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<BDO<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<BDO<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<BDO<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public BDO<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public BDO<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<BDO<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public BDO<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public BDO<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<BDO<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<BDO<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public BDO<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public BDO<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<BDO<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<BDO<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public BDO<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<BDO<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public BDO<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<BDO<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public BDO<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public BDO<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<BDO<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public BDO<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<BDO<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public BDO<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<BDO<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public BDO<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<BDO<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public BDO<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<BDO<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<BDO<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<BDO<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<BDO<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<BDO<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<BDO<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public BDO<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<BDO<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<BDO<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public BDO<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class SPAN<T extends _> extends EImp<T> implements HamletSpec.SPAN {
    public SPAN(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public SPAN<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public SPAN<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public SPAN<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public SPAN<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public SPAN<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public SPAN<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public SPAN<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public SPAN<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public SPAN<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public SPAN<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public SPAN<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public SPAN<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public SPAN<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public SPAN<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public SPAN<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public SPAN<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public SPAN<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public SPAN<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<SPAN<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public SPAN<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public SPAN<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<SPAN<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public SPAN<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public SPAN<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<SPAN<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public SPAN<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public SPAN<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public SPAN<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<SPAN<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public SPAN<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<SPAN<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public SPAN<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public SPAN<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<SPAN<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public SPAN<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public SPAN<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<SPAN<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public SPAN<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public SPAN<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public SPAN<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<SPAN<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public SPAN<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<SPAN<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public SPAN<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public SPAN<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<SPAN<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public SPAN<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public SPAN<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<SPAN<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public SPAN<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public SPAN<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<SPAN<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public SPAN<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public SPAN<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<SPAN<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<SPAN<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public SPAN<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public SPAN<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<SPAN<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public SPAN<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<SPAN<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<SPAN<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<SPAN<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public SPAN<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public SPAN<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<SPAN<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public SPAN<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public SPAN<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<SPAN<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<SPAN<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public SPAN<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public SPAN<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<SPAN<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<SPAN<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public SPAN<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<SPAN<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public SPAN<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<SPAN<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public SPAN<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public SPAN<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<SPAN<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public SPAN<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<SPAN<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public SPAN<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<SPAN<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public SPAN<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<SPAN<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public SPAN<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<SPAN<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<SPAN<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<SPAN<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<SPAN<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<SPAN<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<SPAN<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public SPAN<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<SPAN<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<SPAN<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public SPAN<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class SUP<T extends _> extends EImp<T> implements HamletSpec.SUP {
    public SUP(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public SUP<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public SUP<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public SUP<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public SUP<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public SUP<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public SUP<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public SUP<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public SUP<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public SUP<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public SUP<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public SUP<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public SUP<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public SUP<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public SUP<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public SUP<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public SUP<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public SUP<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public SUP<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<SUP<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public SUP<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public SUP<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<SUP<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public SUP<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public SUP<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<SUP<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public SUP<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public SUP<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public SUP<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<SUP<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public SUP<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<SUP<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public SUP<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public SUP<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<SUP<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public SUP<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public SUP<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<SUP<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public SUP<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public SUP<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public SUP<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<SUP<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public SUP<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<SUP<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public SUP<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public SUP<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<SUP<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public SUP<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public SUP<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<SUP<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public SUP<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public SUP<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<SUP<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public SUP<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public SUP<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<SUP<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<SUP<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public SUP<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public SUP<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<SUP<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public SUP<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<SUP<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<SUP<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<SUP<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public SUP<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public SUP<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<SUP<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public SUP<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public SUP<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<SUP<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<SUP<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public SUP<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public SUP<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<SUP<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<SUP<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public SUP<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<SUP<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public SUP<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<SUP<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public SUP<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public SUP<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<SUP<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public SUP<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<SUP<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public SUP<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<SUP<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public SUP<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<SUP<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public SUP<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<SUP<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<SUP<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<SUP<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<SUP<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<SUP<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<SUP<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public SUP<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<SUP<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<SUP<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public SUP<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class SUB<T extends _> extends EImp<T> implements HamletSpec.SUB {
    public SUB(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public SUB<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public SUB<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public SUB<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public SUB<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public SUB<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public SUB<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public SUB<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public SUB<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public SUB<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public SUB<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public SUB<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public SUB<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public SUB<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public SUB<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public SUB<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public SUB<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public SUB<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public SUB<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<SUB<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public SUB<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public SUB<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<SUB<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public SUB<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public SUB<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<SUB<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public SUB<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public SUB<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public SUB<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<SUB<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public SUB<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<SUB<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public SUB<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public SUB<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<SUB<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public SUB<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public SUB<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<SUB<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public SUB<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public SUB<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public SUB<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<SUB<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public SUB<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<SUB<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public SUB<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public SUB<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<SUB<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public SUB<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public SUB<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<SUB<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public SUB<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public SUB<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<SUB<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public SUB<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public SUB<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<SUB<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<SUB<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public SUB<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public SUB<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<SUB<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public SUB<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<SUB<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<SUB<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<SUB<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public SUB<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public SUB<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<SUB<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public SUB<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public SUB<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<SUB<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<SUB<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public SUB<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public SUB<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<SUB<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<SUB<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public SUB<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<SUB<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public SUB<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<SUB<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public SUB<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public SUB<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<SUB<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public SUB<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<SUB<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public SUB<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<SUB<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public SUB<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<SUB<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public SUB<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<SUB<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<SUB<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<SUB<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<SUB<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<SUB<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<SUB<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public SUB<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<SUB<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<SUB<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public SUB<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class ACRONYM<T extends _> extends EImp<T> implements HamletSpec.ACRONYM {
    public ACRONYM(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public ACRONYM<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public ACRONYM<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public ACRONYM<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public ACRONYM<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public ACRONYM<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public ACRONYM<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public ACRONYM<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public ACRONYM<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public ACRONYM<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public ACRONYM<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public ACRONYM<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public ACRONYM<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public ACRONYM<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public ACRONYM<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public ACRONYM<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public ACRONYM<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public ACRONYM<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public ACRONYM<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<ACRONYM<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public ACRONYM<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public ACRONYM<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<ACRONYM<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public ACRONYM<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public ACRONYM<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<ACRONYM<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public ACRONYM<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public ACRONYM<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public ACRONYM<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<ACRONYM<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public ACRONYM<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<ACRONYM<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public ACRONYM<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public ACRONYM<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<ACRONYM<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public ACRONYM<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public ACRONYM<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<ACRONYM<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public ACRONYM<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public ACRONYM<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public ACRONYM<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<ACRONYM<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public ACRONYM<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<ACRONYM<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public ACRONYM<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public ACRONYM<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<ACRONYM<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public ACRONYM<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public ACRONYM<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<ACRONYM<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public ACRONYM<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public ACRONYM<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<ACRONYM<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public ACRONYM<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public ACRONYM<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<ACRONYM<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<ACRONYM<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public ACRONYM<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public ACRONYM<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<ACRONYM<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public ACRONYM<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<ACRONYM<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<ACRONYM<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<ACRONYM<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public ACRONYM<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public ACRONYM<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<ACRONYM<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public ACRONYM<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public ACRONYM<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<ACRONYM<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<ACRONYM<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public ACRONYM<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public ACRONYM<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<ACRONYM<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<ACRONYM<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public ACRONYM<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<ACRONYM<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public ACRONYM<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<ACRONYM<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public ACRONYM<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public ACRONYM<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<ACRONYM<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public ACRONYM<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<ACRONYM<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public ACRONYM<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<ACRONYM<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public ACRONYM<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<ACRONYM<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public ACRONYM<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<ACRONYM<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<ACRONYM<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<ACRONYM<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<ACRONYM<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<ACRONYM<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<ACRONYM<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public ACRONYM<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<ACRONYM<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<ACRONYM<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public ACRONYM<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class ABBR<T extends _> extends EImp<T> implements HamletSpec.ABBR {
    public ABBR(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public ABBR<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public ABBR<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public ABBR<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public ABBR<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public ABBR<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public ABBR<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public ABBR<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public ABBR<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public ABBR<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public ABBR<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public ABBR<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public ABBR<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public ABBR<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public ABBR<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public ABBR<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public ABBR<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public ABBR<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public ABBR<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<ABBR<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public ABBR<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public ABBR<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<ABBR<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public ABBR<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public ABBR<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<ABBR<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public ABBR<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public ABBR<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public ABBR<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<ABBR<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public ABBR<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<ABBR<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public ABBR<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public ABBR<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<ABBR<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public ABBR<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public ABBR<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<ABBR<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public ABBR<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public ABBR<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public ABBR<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<ABBR<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public ABBR<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<ABBR<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public ABBR<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public ABBR<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<ABBR<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public ABBR<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public ABBR<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<ABBR<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public ABBR<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public ABBR<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<ABBR<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public ABBR<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public ABBR<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<ABBR<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<ABBR<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public ABBR<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public ABBR<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<ABBR<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public ABBR<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<ABBR<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<ABBR<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<ABBR<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public ABBR<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public ABBR<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<ABBR<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public ABBR<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public ABBR<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<ABBR<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<ABBR<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public ABBR<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public ABBR<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<ABBR<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<ABBR<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public ABBR<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<ABBR<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public ABBR<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<ABBR<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public ABBR<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public ABBR<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<ABBR<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public ABBR<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<ABBR<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public ABBR<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<ABBR<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public ABBR<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<ABBR<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public ABBR<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<ABBR<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<ABBR<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<ABBR<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<ABBR<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<ABBR<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<ABBR<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public ABBR<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<ABBR<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<ABBR<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public ABBR<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class CITE<T extends _> extends EImp<T> implements HamletSpec.CITE {
    public CITE(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public CITE<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public CITE<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public CITE<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public CITE<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public CITE<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public CITE<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public CITE<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public CITE<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public CITE<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public CITE<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public CITE<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public CITE<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public CITE<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public CITE<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public CITE<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public CITE<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public CITE<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public CITE<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<CITE<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public CITE<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public CITE<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<CITE<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public CITE<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public CITE<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<CITE<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public CITE<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public CITE<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public CITE<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<CITE<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public CITE<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<CITE<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public CITE<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public CITE<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<CITE<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public CITE<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public CITE<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<CITE<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public CITE<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public CITE<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public CITE<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<CITE<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public CITE<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<CITE<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public CITE<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public CITE<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<CITE<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public CITE<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public CITE<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<CITE<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public CITE<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public CITE<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<CITE<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public CITE<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public CITE<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<CITE<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<CITE<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public CITE<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public CITE<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<CITE<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public CITE<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<CITE<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<CITE<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<CITE<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public CITE<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public CITE<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<CITE<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public CITE<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public CITE<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<CITE<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<CITE<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public CITE<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public CITE<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<CITE<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<CITE<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public CITE<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<CITE<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public CITE<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<CITE<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public CITE<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public CITE<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<CITE<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public CITE<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<CITE<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public CITE<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<CITE<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public CITE<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<CITE<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public CITE<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<CITE<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<CITE<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<CITE<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<CITE<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<CITE<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<CITE<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public CITE<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<CITE<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<CITE<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public CITE<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class VAR<T extends _> extends EImp<T> implements HamletSpec.VAR {
    public VAR(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public VAR<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public VAR<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public VAR<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public VAR<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public VAR<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public VAR<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public VAR<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public VAR<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public VAR<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public VAR<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public VAR<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public VAR<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public VAR<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public VAR<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public VAR<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public VAR<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public VAR<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public VAR<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<VAR<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public VAR<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public VAR<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<VAR<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public VAR<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public VAR<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<VAR<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public VAR<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public VAR<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public VAR<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<VAR<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public VAR<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<VAR<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public VAR<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public VAR<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<VAR<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public VAR<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public VAR<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<VAR<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public VAR<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public VAR<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public VAR<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<VAR<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public VAR<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<VAR<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public VAR<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public VAR<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<VAR<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public VAR<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public VAR<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<VAR<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public VAR<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public VAR<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<VAR<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public VAR<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public VAR<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<VAR<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<VAR<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public VAR<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public VAR<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<VAR<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public VAR<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<VAR<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<VAR<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<VAR<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public VAR<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public VAR<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<VAR<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public VAR<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public VAR<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<VAR<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<VAR<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public VAR<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public VAR<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<VAR<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<VAR<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public VAR<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<VAR<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public VAR<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<VAR<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public VAR<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public VAR<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<VAR<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public VAR<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<VAR<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public VAR<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<VAR<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public VAR<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<VAR<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public VAR<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<VAR<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<VAR<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<VAR<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<VAR<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<VAR<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<VAR<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public VAR<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<VAR<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<VAR<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public VAR<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class KBD<T extends _> extends EImp<T> implements HamletSpec.KBD {
    public KBD(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public KBD<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public KBD<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public KBD<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public KBD<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public KBD<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public KBD<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public KBD<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public KBD<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public KBD<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public KBD<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public KBD<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public KBD<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public KBD<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public KBD<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public KBD<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public KBD<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public KBD<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public KBD<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<KBD<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public KBD<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public KBD<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<KBD<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public KBD<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public KBD<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<KBD<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public KBD<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public KBD<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public KBD<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<KBD<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public KBD<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<KBD<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public KBD<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public KBD<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<KBD<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public KBD<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public KBD<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<KBD<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public KBD<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public KBD<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public KBD<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<KBD<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public KBD<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<KBD<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public KBD<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public KBD<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<KBD<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public KBD<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public KBD<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<KBD<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public KBD<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public KBD<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<KBD<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public KBD<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public KBD<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<KBD<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<KBD<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public KBD<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public KBD<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<KBD<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public KBD<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<KBD<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<KBD<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<KBD<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public KBD<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public KBD<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<KBD<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public KBD<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public KBD<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<KBD<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<KBD<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public KBD<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public KBD<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<KBD<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<KBD<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public KBD<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<KBD<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public KBD<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<KBD<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public KBD<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public KBD<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<KBD<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public KBD<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<KBD<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public KBD<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<KBD<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public KBD<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<KBD<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public KBD<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<KBD<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<KBD<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<KBD<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<KBD<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<KBD<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<KBD<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public KBD<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<KBD<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<KBD<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public KBD<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class SAMP<T extends _> extends EImp<T> implements HamletSpec.SAMP {
    public SAMP(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public SAMP<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public SAMP<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public SAMP<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public SAMP<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public SAMP<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public SAMP<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public SAMP<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public SAMP<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public SAMP<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public SAMP<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public SAMP<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public SAMP<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public SAMP<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public SAMP<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public SAMP<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public SAMP<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public SAMP<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public SAMP<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<SAMP<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public SAMP<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public SAMP<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<SAMP<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public SAMP<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public SAMP<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<SAMP<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public SAMP<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public SAMP<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public SAMP<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<SAMP<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public SAMP<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<SAMP<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public SAMP<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public SAMP<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<SAMP<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public SAMP<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public SAMP<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<SAMP<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public SAMP<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public SAMP<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public SAMP<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<SAMP<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public SAMP<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<SAMP<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public SAMP<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public SAMP<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<SAMP<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public SAMP<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public SAMP<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<SAMP<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public SAMP<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public SAMP<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<SAMP<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public SAMP<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public SAMP<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<SAMP<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<SAMP<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public SAMP<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public SAMP<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<SAMP<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public SAMP<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<SAMP<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<SAMP<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<SAMP<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public SAMP<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public SAMP<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<SAMP<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public SAMP<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public SAMP<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<SAMP<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<SAMP<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public SAMP<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public SAMP<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<SAMP<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<SAMP<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public SAMP<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<SAMP<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public SAMP<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<SAMP<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public SAMP<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public SAMP<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<SAMP<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public SAMP<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<SAMP<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public SAMP<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<SAMP<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public SAMP<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<SAMP<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public SAMP<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<SAMP<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<SAMP<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<SAMP<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<SAMP<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<SAMP<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<SAMP<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public SAMP<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<SAMP<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<SAMP<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public SAMP<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class CODE<T extends _> extends EImp<T> implements HamletSpec.CODE {
    public CODE(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public CODE<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public CODE<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public CODE<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public CODE<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public CODE<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public CODE<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public CODE<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public CODE<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public CODE<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public CODE<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public CODE<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public CODE<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public CODE<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public CODE<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public CODE<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public CODE<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public CODE<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public CODE<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<CODE<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public CODE<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public CODE<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<CODE<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public CODE<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public CODE<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<CODE<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public CODE<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public CODE<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public CODE<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<CODE<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public CODE<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<CODE<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public CODE<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public CODE<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<CODE<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public CODE<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public CODE<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<CODE<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public CODE<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public CODE<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public CODE<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<CODE<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public CODE<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<CODE<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public CODE<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public CODE<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<CODE<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public CODE<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public CODE<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<CODE<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public CODE<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public CODE<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<CODE<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public CODE<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public CODE<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<CODE<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<CODE<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public CODE<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public CODE<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<CODE<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public CODE<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<CODE<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<CODE<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<CODE<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public CODE<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public CODE<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<CODE<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public CODE<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public CODE<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<CODE<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<CODE<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public CODE<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public CODE<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<CODE<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<CODE<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public CODE<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<CODE<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public CODE<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<CODE<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public CODE<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public CODE<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<CODE<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public CODE<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<CODE<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public CODE<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<CODE<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public CODE<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<CODE<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public CODE<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<CODE<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<CODE<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<CODE<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<CODE<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<CODE<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<CODE<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public CODE<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<CODE<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<CODE<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public CODE<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class DFN<T extends _> extends EImp<T> implements HamletSpec.DFN {
    public DFN(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public DFN<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public DFN<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public DFN<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public DFN<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public DFN<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public DFN<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public DFN<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public DFN<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public DFN<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public DFN<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public DFN<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public DFN<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public DFN<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public DFN<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public DFN<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public DFN<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public DFN<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public DFN<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<DFN<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public DFN<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public DFN<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<DFN<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public DFN<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public DFN<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<DFN<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public DFN<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public DFN<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public DFN<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<DFN<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public DFN<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<DFN<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public DFN<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public DFN<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<DFN<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public DFN<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public DFN<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<DFN<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public DFN<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public DFN<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public DFN<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<DFN<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public DFN<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<DFN<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public DFN<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public DFN<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<DFN<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public DFN<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public DFN<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<DFN<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public DFN<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public DFN<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<DFN<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public DFN<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public DFN<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<DFN<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<DFN<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public DFN<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public DFN<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<DFN<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public DFN<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<DFN<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<DFN<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<DFN<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public DFN<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public DFN<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<DFN<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public DFN<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public DFN<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<DFN<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<DFN<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public DFN<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public DFN<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<DFN<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<DFN<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public DFN<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<DFN<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public DFN<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<DFN<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public DFN<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public DFN<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<DFN<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public DFN<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<DFN<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public DFN<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<DFN<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public DFN<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<DFN<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public DFN<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<DFN<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<DFN<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<DFN<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<DFN<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<DFN<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<DFN<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public DFN<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<DFN<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<DFN<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public DFN<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class STRONG<T extends _> extends EImp<T> implements HamletSpec.STRONG {
    public STRONG(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public STRONG<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public STRONG<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public STRONG<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public STRONG<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public STRONG<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public STRONG<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public STRONG<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public STRONG<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public STRONG<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public STRONG<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public STRONG<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public STRONG<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public STRONG<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public STRONG<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public STRONG<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public STRONG<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public STRONG<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public STRONG<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<STRONG<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public STRONG<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public STRONG<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<STRONG<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public STRONG<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public STRONG<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<STRONG<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public STRONG<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public STRONG<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public STRONG<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<STRONG<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public STRONG<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<STRONG<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public STRONG<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public STRONG<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<STRONG<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public STRONG<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public STRONG<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<STRONG<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public STRONG<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public STRONG<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public STRONG<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<STRONG<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public STRONG<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<STRONG<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public STRONG<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public STRONG<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<STRONG<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public STRONG<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public STRONG<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<STRONG<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public STRONG<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public STRONG<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<STRONG<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public STRONG<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public STRONG<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<STRONG<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<STRONG<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public STRONG<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public STRONG<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<STRONG<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public STRONG<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<STRONG<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<STRONG<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<STRONG<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public STRONG<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public STRONG<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<STRONG<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public STRONG<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public STRONG<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<STRONG<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<STRONG<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public STRONG<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public STRONG<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<STRONG<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<STRONG<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public STRONG<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<STRONG<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public STRONG<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<STRONG<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public STRONG<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public STRONG<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<STRONG<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public STRONG<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<STRONG<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public STRONG<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<STRONG<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public STRONG<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<STRONG<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public STRONG<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<STRONG<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<STRONG<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<STRONG<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<STRONG<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<STRONG<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<STRONG<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public STRONG<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<STRONG<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<STRONG<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public STRONG<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class EM<T extends _> extends EImp<T> implements HamletSpec.EM {
    public EM(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public EM<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public EM<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public EM<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public EM<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public EM<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public EM<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public EM<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public EM<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public EM<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public EM<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public EM<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public EM<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public EM<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public EM<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public EM<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public EM<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public EM<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public EM<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<EM<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public EM<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public EM<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<EM<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public EM<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public EM<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<EM<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public EM<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public EM<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public EM<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<EM<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public EM<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<EM<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public EM<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public EM<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<EM<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public EM<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public EM<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<EM<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public EM<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public EM<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public EM<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<EM<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public EM<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<EM<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public EM<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public EM<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<EM<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public EM<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public EM<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<EM<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public EM<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public EM<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<EM<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public EM<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public EM<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<EM<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<EM<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public EM<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public EM<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<EM<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public EM<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<EM<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<EM<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<EM<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public EM<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public EM<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<EM<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public EM<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public EM<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<EM<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<EM<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public EM<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public EM<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<EM<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<EM<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public EM<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<EM<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public EM<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<EM<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public EM<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public EM<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<EM<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public EM<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<EM<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public EM<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<EM<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public EM<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<EM<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public EM<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<EM<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<EM<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<EM<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<EM<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<EM<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<EM<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public EM<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<EM<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<EM<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public EM<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class SMALL<T extends _> extends EImp<T> implements HamletSpec.SMALL {
    public SMALL(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public SMALL<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public SMALL<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public SMALL<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public SMALL<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public SMALL<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public SMALL<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public SMALL<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public SMALL<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public SMALL<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public SMALL<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public SMALL<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public SMALL<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public SMALL<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public SMALL<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public SMALL<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public SMALL<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public SMALL<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public SMALL<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<SMALL<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public SMALL<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public SMALL<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<SMALL<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public SMALL<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public SMALL<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<SMALL<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public SMALL<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public SMALL<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public SMALL<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<SMALL<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public SMALL<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<SMALL<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public SMALL<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public SMALL<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<SMALL<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public SMALL<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public SMALL<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<SMALL<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public SMALL<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public SMALL<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public SMALL<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<SMALL<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public SMALL<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<SMALL<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public SMALL<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public SMALL<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<SMALL<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public SMALL<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public SMALL<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<SMALL<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public SMALL<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public SMALL<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<SMALL<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public SMALL<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public SMALL<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<SMALL<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<SMALL<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public SMALL<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public SMALL<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<SMALL<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public SMALL<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<SMALL<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<SMALL<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<SMALL<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public SMALL<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public SMALL<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<SMALL<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public SMALL<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public SMALL<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<SMALL<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<SMALL<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public SMALL<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public SMALL<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<SMALL<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<SMALL<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public SMALL<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<SMALL<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public SMALL<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<SMALL<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public SMALL<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public SMALL<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<SMALL<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public SMALL<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<SMALL<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public SMALL<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<SMALL<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public SMALL<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<SMALL<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public SMALL<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<SMALL<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<SMALL<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<SMALL<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<SMALL<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<SMALL<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<SMALL<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public SMALL<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<SMALL<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<SMALL<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public SMALL<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class B<T extends _> extends EImp<T> implements HamletSpec.B {
    public B(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public B<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public B<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public B<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public B<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public B<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public B<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public B<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public B<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public B<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public B<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public B<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public B<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public B<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public B<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public B<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public B<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public B<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public B<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<B<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public B<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public B<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<B<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public B<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public B<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<B<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public B<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public B<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public B<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<B<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public B<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<B<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public B<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public B<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<B<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public B<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public B<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<B<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public B<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public B<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public B<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<B<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public B<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<B<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public B<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public B<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<B<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public B<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public B<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<B<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public B<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public B<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<B<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public B<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public B<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<B<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<B<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public B<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public B<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<B<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public B<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<B<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<B<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<B<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public B<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public B<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<B<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public B<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public B<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<B<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<B<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public B<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public B<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<B<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<B<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public B<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<B<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public B<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<B<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public B<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public B<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<B<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public B<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<B<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public B<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<B<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public B<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<B<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public B<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<B<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<B<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<B<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<B<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<B<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<B<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public B<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<B<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<B<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public B<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  public class I<T extends _> extends EImp<T> implements HamletSpec.I {
    public I(String name, T parent, EnumSet<EOpt> opts) {
      super(name, parent, opts);
    }

    
    public I<T> $id(String value) {
      addAttr("id", value);
      return this;
    }

    
    public I<T> $class(String value) {
      addAttr("class", value);
      return this;
    }

    
    public I<T> $title(String value) {
      addAttr("title", value);
      return this;
    }

    
    public I<T> $style(String value) {
      addAttr("style", value);
      return this;
    }

    
    public I<T> $lang(String value) {
      addAttr("lang", value);
      return this;
    }

    
    public I<T> $dir(Dir value) {
      addAttr("dir", value);
      return this;
    }

    
    public I<T> $onclick(String value) {
      addAttr("onclick", value);
      return this;
    }

    
    public I<T> $ondblclick(String value) {
      addAttr("ondblclick", value);
      return this;
    }

    
    public I<T> $onmousedown(String value) {
      addAttr("onmousedown", value);
      return this;
    }

    
    public I<T> $onmouseup(String value) {
      addAttr("onmouseup", value);
      return this;
    }

    
    public I<T> $onmouseover(String value) {
      addAttr("onmouseover", value);
      return this;
    }

    
    public I<T> $onmousemove(String value) {
      addAttr("onmousemove", value);
      return this;
    }

    
    public I<T> $onmouseout(String value) {
      addAttr("onmouseout", value);
      return this;
    }

    
    public I<T> $onkeypress(String value) {
      addAttr("onkeypress", value);
      return this;
    }

    
    public I<T> $onkeydown(String value) {
      addAttr("onkeydown", value);
      return this;
    }

    
    public I<T> $onkeyup(String value) {
      addAttr("onkeyup", value);
      return this;
    }

    
    public I<T> _(Object... lines) {
      _p(true, lines);
      return this;
    }

    
    public I<T> _r(Object... lines) {
      _p(false, lines);
      return this;
    }

    
    public B<I<T>> b() {
      closeAttrs();
      return b_(this, true);
    }

    
    public I<T> b(String cdata) {
      return b()._(cdata)._();
    }

    
    public I<T> b(String selector, String cdata) {
      return setSelector(b(), selector)._(cdata)._();
    }

    
    public I<I<T>> i() {
      closeAttrs();
      return i_(this, true);
    }

    
    public I<T> i(String cdata) {
      return i()._(cdata)._();
    }

    
    public I<T> i(String selector, String cdata) {
      return setSelector(i(), selector)._(cdata)._();
    }

    
    public SMALL<I<T>> small() {
      closeAttrs();
      return small_(this, true);
    }

    
    public I<T> small(String cdata) {
      return small()._(cdata)._();
    }

    
    public I<T> small(String selector, String cdata) {
      return setSelector(small(), selector)._(cdata)._();
    }

    
    public I<T> em(String cdata) {
      return em()._(cdata)._();
    }

    
    public EM<I<T>> em() {
      closeAttrs();
      return em_(this, true);
    }

    
    public I<T> em(String selector, String cdata) {
      return setSelector(em(), selector)._(cdata)._();
    }

    
    public STRONG<I<T>> strong() {
      closeAttrs();
      return strong_(this, true);
    }

    
    public I<T> strong(String cdata) {
      return strong()._(cdata)._();
    }

    
    public I<T> strong(String selector, String cdata) {
      return setSelector(strong(), selector)._(cdata)._();
    }

    
    public DFN<I<T>> dfn() {
      closeAttrs();
      return dfn_(this, true);
    }

    
    public I<T> dfn(String cdata) {
      return dfn()._(cdata)._();
    }

    
    public I<T> dfn(String selector, String cdata) {
      return setSelector(dfn(), selector)._(cdata)._();
    }

    
    public CODE<I<T>> code() {
      closeAttrs();
      return code_(this, true);
    }

    
    public I<T> code(String cdata) {
      return code()._(cdata)._();
    }

    
    public I<T> code(String selector, String cdata) {
      return setSelector(code(), selector)._(cdata)._();
    }

    
    public I<T> samp(String cdata) {
      return samp()._(cdata)._();
    }

    
    public SAMP<I<T>> samp() {
      closeAttrs();
      return samp_(this, true);
    }

    
    public I<T> samp(String selector, String cdata) {
      return setSelector(samp(), selector)._(cdata)._();
    }

    
    public KBD<I<T>> kbd() {
      closeAttrs();
      return kbd_(this, true);
    }

    
    public I<T> kbd(String cdata) {
      return kbd()._(cdata)._();
    }

    
    public I<T> kbd(String selector, String cdata) {
      return setSelector(kbd(), selector)._(cdata)._();
    }

    
    public VAR<I<T>> var() {
      closeAttrs();
      return var_(this, true);
    }

    
    public I<T> var(String cdata) {
      return var()._(cdata)._();
    }

    
    public I<T> var(String selector, String cdata) {
      return setSelector(var(), selector)._(cdata)._();
    }

    
    public CITE<I<T>> cite() {
      closeAttrs();
      return cite_(this, true);
    }

    
    public I<T> cite(String cdata) {
      return cite()._(cdata)._();
    }

    
    public I<T> cite(String selector, String cdata) {
      return setSelector(cite(), selector)._(cdata)._();
    }

    
    public ABBR<I<T>> abbr() {
      closeAttrs();
      return abbr_(this, true);
    }

    
    public I<T> abbr(String cdata) {
      return abbr()._(cdata)._();
    }

    
    public I<T> abbr(String selector, String cdata) {
      return setSelector(abbr(), selector)._(cdata)._();
    }

    
    public A<I<T>> a() {
      closeAttrs();
      return a_(this, true);
    }

    
    public A<I<T>> a(String selector) {
      return setSelector(a(), selector);
    }

    
    public I<T> a(String href, String anchorText) {
      return a().$href(href)._(anchorText)._();
    }

    
    public I<T> a(String selector, String href, String anchorText) {
      return setSelector(a(), selector).$href(href)._(anchorText)._();
    }

    
    public IMG<I<T>> img() {
      closeAttrs();
      return img_(this, true);
    }

    
    public I<T> img(String src) {
      return img().$src(src)._();
    }

    
    public OBJECT<I<T>> object() {
      closeAttrs();
      return object_(this, true);
    }

    
    public OBJECT<I<T>> object(String selector) {
      return setSelector(object(), selector);
    }

    
    public SUB<I<T>> sub() {
      closeAttrs();
      return sub_(this, true);
    }

    
    public I<T> sub(String cdata) {
      return sub()._(cdata)._();
    }

    
    public I<T> sub(String selector, String cdata) {
      return setSelector(sub(), selector)._(cdata)._();
    }

    
    public SUP<I<T>> sup() {
      closeAttrs();
      return sup_(this, true);
    }

    
    public I<T> sup(String cdata) {
      return sup()._(cdata)._();
    }

    
    public I<T> sup(String selector, String cdata) {
      return setSelector(sup(), selector)._(cdata)._();
    }

    
    public MAP<I<T>> map() {
      closeAttrs();
      return map_(this, true);
    }

    
    public MAP<I<T>> map(String selector) {
      return setSelector(map(), selector);
    }

    
    public I<T> q(String cdata) {
      return q()._(cdata)._();
    }

    
    public I<T> q(String selector, String cdata) {
      return setSelector(q(), selector)._(cdata)._();
    }

    
    public Q<I<T>> q() {
      closeAttrs();
      return q_(this, true);
    }

    
    public BR<I<T>> br() {
      closeAttrs();
      return br_(this, true);
    }

    
    public I<T> br(String selector) {
      return setSelector(br(), selector)._();
    }

    
    public BDO<I<T>> bdo() {
      closeAttrs();
      return bdo_(this, true);
    }

    
    public I<T> bdo(Dir dir, String cdata) {
      return bdo().$dir(dir)._(cdata)._();
    }

    
    public SPAN<I<T>> span() {
      closeAttrs();
      return span_(this, true);
    }

    
    public I<T> span(String cdata) {
      return span()._(cdata)._();
    }

    
    public I<T> span(String selector, String cdata) {
      return setSelector(span(), selector)._(cdata)._();
    }

    
    public SCRIPT<I<T>> script() {
      closeAttrs();
      return script_(this, true);
    }

    
    public I<T> script(String src) {
      return setScriptSrc(script(), src)._();
    }

    
    public INS<I<T>> ins() {
      closeAttrs();
      return ins_(this, true);
    }

    
    public I<T> ins(String cdata) {
      return ins()._(cdata)._();
    }

    
    public DEL<I<T>> del() {
      closeAttrs();
      return del_(this, true);
    }

    
    public I<T> del(String cdata) {
      return del()._(cdata)._();
    }

    
    public LABEL<I<T>> label() {
      closeAttrs();
      return label_(this, true);
    }

    
    public I<T> label(String forId, String cdata) {
      return label().$for(forId)._(cdata)._();
    }

    
    public INPUT<I<T>> input(String selector) {
      return setSelector(input(), selector);
    }

    
    public INPUT<I<T>> input() {
      closeAttrs();
      return input_(this, true);
    }

    
    public SELECT<I<T>> select() {
      closeAttrs();
      return select_(this, true);
    }

    
    public SELECT<I<T>> select(String selector) {
      return setSelector(select(), selector);
    }

    
    public TEXTAREA<I<T>> textarea(String selector) {
      return setSelector(textarea(), selector);
    }

    
    public TEXTAREA<I<T>> textarea() {
      closeAttrs();
      return textarea_(this, true);
    }

    
    public I<T> textarea(String selector, String cdata) {
      return setSelector(textarea(), selector)._(cdata)._();
    }

    
    public BUTTON<I<T>> button() {
      closeAttrs();
      return button_(this, true);
    }

    
    public BUTTON<I<T>> button(String selector) {
      return setSelector(button(), selector);
    }

    
    public I<T> button(String selector, String cdata) {
      return setSelector(button(), selector)._(cdata)._();
    }
  }

  private <T extends _> INPUT<T> input_(T e, boolean inline) {
    return new INPUT<T>("input", e, opt(false, inline, false)); }

  private <T extends _> SELECT<T> select_(T e, boolean inline) {
    return new SELECT<T>("select", e, opt(true, inline, false)); }

  private <T extends _> TEXTAREA<T> textarea_(T e, boolean inline) {
    return new TEXTAREA<T>("textarea", e, opt(true, inline, false)); }

  private <T extends _> BUTTON<T> button_(T e, boolean inline) {
    return new BUTTON<T>("button", e, opt(true, inline, false)); }

  private <T extends _> LABEL<T> label_(T e, boolean inline) {
    return new LABEL<T>("label", e, opt(true, inline, false)); }

  private <T extends _> MAP<T> map_(T e, boolean inline) {
    return new MAP<T>("map", e, opt(true, inline, false)); }

  private <T extends _> Q<T> q_(T e, boolean inline) {
    return new Q<T>("q", e, opt(true, inline, false)); }

  private <T extends _> BR<T> br_(T e, boolean inline) {
    return new BR<T>("br", e, opt(false, inline, false)); }

  private <T extends _> BDO<T> bdo_(T e, boolean inline) {
    return new BDO<T>("bdo", e, opt(true, inline, false)); }

  private <T extends _> SPAN<T> span_(T e, boolean inline) {
    return new SPAN<T>("span", e, opt(true, inline, false)); }

  private <T extends _> INS<T> ins_(T e, boolean inline) {
    return new INS<T>("ins", e, opt(true, inline, false)); }

  private <T extends _> DEL<T> del_(T e, boolean inline) {
    return new DEL<T>("del", e, opt(true, inline, false)); }

  private <T extends _> A<T> a_(T e, boolean inline) {
    return new A<T>("a", e, opt(true, inline, false)); }

  private <T extends _> SUB<T> sub_(T e, boolean inline) {
    return new SUB<T>("sub", e, opt(true, inline, false)); }

  private <T extends _> SUP<T> sup_(T e, boolean inline) {
    return new SUP<T>("sup", e, opt(true, inline, false)); }

  private <T extends _> IMG<T> img_(T e, boolean inline) {
    return new IMG<T>("img", e, opt(false, inline, false)); }

  private <T extends _> EM<T> em_(T e, boolean inline) {
    return new EM<T>("em", e, opt(true, inline, false)); }

  private <T extends _> STRONG<T> strong_(T e, boolean inline) {
    return new STRONG<T>("strong", e, opt(true, inline, false)); }

  private <T extends _> DFN<T> dfn_(T e, boolean inline) {
    return new DFN<T>("dfn", e, opt(true, inline, false)); }

  private <T extends _> CODE<T> code_(T e, boolean inline) {
    return new CODE<T>("code", e, opt(true, inline, false)); }

  private <T extends _> SAMP<T> samp_(T e, boolean inline) {
    return new SAMP<T>("samp", e, opt(true, inline, false)); }

  private <T extends _> KBD<T> kbd_(T e, boolean inline) {
    return new KBD<T>("kbd", e, opt(true, inline, false)); }

  private <T extends _> VAR<T> var_(T e, boolean inline) {
    return new VAR<T>("var", e, opt(true, inline, false)); }

  private <T extends _> CITE<T> cite_(T e, boolean inline) {
    return new CITE<T>("cite", e, opt(true, inline, false)); }

  private <T extends _> ABBR<T> abbr_(T e, boolean inline) {
    return new ABBR<T>("abbr", e, opt(true, inline, false)); }

  private <T extends _> B<T> b_(T e, boolean inline) {
    return new B<T>("b", e, opt(true, inline, false)); }

  private <T extends _> I<T> i_(T e, boolean inline) {
    return new I<T>("i", e, opt(true, inline, false)); }

  private <T extends _> SMALL<T> small_(T e, boolean inline) {
    return new SMALL<T>("small", e, opt(true, inline, false)); }

  private <T extends _> PRE<T> pre_(T e, boolean inline) {
    return new PRE<T>("pre", e, opt(true, inline, true)); }

  private <T extends _> UL<T> ul_(T e, boolean inline) {
    return new UL<T>("ul", e, opt(true, inline, false)); }

  private <T extends _> OL<T> ol_(T e, boolean inline) {
    return new OL<T>("ol", e, opt(true, inline, false)); }

  private <T extends _> H1<T> h1_(T e, boolean inline) {
    return new H1<T>("h1", e, opt(true, inline, false)); }

  private <T extends _> H2<T> h2_(T e, boolean inline) {
    return new H2<T>("h2", e, opt(true, inline, false)); }

  private <T extends _> H3<T> h3_(T e, boolean inline) {
    return new H3<T>("h3", e, opt(true, inline, false)); }

  private <T extends _> H4<T> h4_(T e, boolean inline) {
    return new H4<T>("h4", e, opt(true, inline, false)); }

  private <T extends _> H5<T> h5_(T e, boolean inline) {
    return new H5<T>("h5", e, opt(true, inline, false)); }

  private <T extends _> H6<T> h6_(T e, boolean inline) {
    return new H6<T>("h6", e, opt(true, inline, false)); }

  private <T extends _> STYLE<T> style_(T e, boolean inline) {
    return new STYLE<T>("style", e, opt(true, inline, false)); }

  private <T extends _> LINK<T> link_(T e, boolean inline) {
    return new LINK<T>("link", e, opt(false, inline, false)); }

  private <T extends _> META<T> meta_(T e, boolean inline) {
    return new META<T>("meta", e, opt(false, inline, false)); }

  private <T extends _> OBJECT<T> object_(T e, boolean inline) {
    return new OBJECT<T>("object", e, opt(true, inline, false)); }

  private <T extends _> SCRIPT<T> script_(T e, boolean inline) {
    return new SCRIPT<T>("script", e, opt(true, inline, false)); }

  
  public HEAD<Hamlet> head() {
  return head_(this, false);
  }

  
  public BODY<Hamlet> body() {
  return body_(this, false);
  }

  
  public BODY<Hamlet> body(String selector) {
    return setSelector(body(), selector);
  }

  
  public BASE<Hamlet> base() {
  return base_(this, false);
  }

  
  public Hamlet base(String href) {
    return base().$href(href)._();
  }

  
  public TITLE<Hamlet> title() {
  return title_(this, false);
  }

  
  public Hamlet title(String cdata) {
    return title()._(cdata)._();
  }

  
  public STYLE<Hamlet> style() {
  return style_(this, false);
  }

  
  public Hamlet style(Object... lines) {
    return style().$type("text/css")._(lines)._();
  }

  
  public LINK<Hamlet> link() {
  return link_(this, false);
  }

  
  public Hamlet link(String href) {
    return setLinkHref(link(), href)._();
  }

  
  public META<Hamlet> meta() {
  return meta_(this, false);
  }

  
  public Hamlet meta(String name, String content) {
    return meta().$name(name).$content(content)._();
  }

  
  public Hamlet meta_http(String header, String content) {
    return meta().$http_equiv(header).$content(content)._();
  }

  
  public SCRIPT<Hamlet> script() {
  return script_(this, false);
  }

  
  public Hamlet script(String src) {
    return setScriptSrc(script(), src)._();
  }

  
  public OBJECT<Hamlet> object() {
  return object_(this, true);
  }

  
  public OBJECT<Hamlet> object(String selector) {
    return setSelector(object(), selector);
  }

  
  public TABLE<Hamlet> table() {
  return table_(this, false);
  }

  
  public TABLE<Hamlet> table(String selector) {
    return setSelector(table(), selector);
  }

  
  public Hamlet address(String cdata) {
    return address()._(cdata)._();
  }

  
  public ADDRESS<Hamlet> address() {
  return address_(this, false);
  }

  
  public P<Hamlet> p(String selector) {
    return setSelector(p(), selector);
  }

  
  public P<Hamlet> p() {
  return p_(this, false);
  }

  
  public Hamlet _(Class<? extends SubView> cls) {
    subView(cls);
    return this;
  }

  
  public HR<Hamlet> hr() {
  return hr_(this, false);
  }

  
  public Hamlet hr(String selector) {
    return setSelector(hr(), selector)._();
  }

  
  public DL<Hamlet> dl(String selector) {
    return setSelector(dl(), selector);
  }

  
  public DL<Hamlet> dl() {
  return dl_(this, false);
  }

  
  public DIV<Hamlet> div(String selector) {
    return setSelector(div(), selector);
  }

  
  public DIV<Hamlet> div() {
  return div_(this, false);
  }

  
  public BLOCKQUOTE<Hamlet> blockquote() {
  return blockquote_(this, false);
  }

  
  public BLOCKQUOTE<Hamlet> bq() {
  return blockquote_(this, false);
  }

  
  public Hamlet h1(String cdata) {
    return h1()._(cdata)._();
  }

  
  public H1<Hamlet> h1() {
  return h1_(this, false);
  }

  
  public Hamlet h1(String selector, String cdata) {
    return setSelector(h1(), selector)._(cdata)._();
  }

  
  public Hamlet h2(String cdata) {
    return h2()._(cdata)._();
  }

  
  public H2<Hamlet> h2() {
  return h2_(this, false);
  }

  
  public Hamlet h2(String selector, String cdata) {
    return setSelector(h2(), selector)._(cdata)._();
  }

  
  public H3<Hamlet> h3() {
  return h3_(this, false);
  }

  
  public Hamlet h3(String cdata) {
    return h3()._(cdata)._();
  }

  
  public Hamlet h3(String selector, String cdata) {
    return setSelector(h3(), selector)._(cdata)._();
  }

  
  public H4<Hamlet> h4() {
  return h4_(this, false);
  }

  
  public Hamlet h4(String cdata) {
    return h4()._(cdata)._();
  }

  
  public Hamlet h4(String selector, String cdata) {
    return setSelector(h4(), selector)._(cdata)._();
  }

  
  public H5<Hamlet> h5() {
  return h5_(this, false);
  }

  
  public Hamlet h5(String cdata) {
    return h5()._(cdata)._();
  }

  
  public Hamlet h5(String selector, String cdata) {
    return setSelector(h5(), selector)._(cdata)._();
  }

  
  public H6<Hamlet> h6() {
  return h6_(this, false);
  }

  
  public Hamlet h6(String cdata) {
    return h6()._(cdata)._();
  }

  
  public Hamlet h6(String selector, String cdata) {
    return setSelector(h6(), selector)._(cdata)._();
  }

  
  public UL<Hamlet> ul() {
  return ul_(this, false);
  }

  
  public UL<Hamlet> ul(String selector) {
    return setSelector(ul(), selector);
  }

  
  public OL<Hamlet> ol() {
  return ol_(this, false);
  }

  
  public OL<Hamlet> ol(String selector) {
    return setSelector(ol(), selector);
  }

  
  public PRE<Hamlet> pre() {
  return pre_(this, false);
  }

  
  public PRE<Hamlet> pre(String selector) {
    return setSelector(pre(), selector);
  }

  
  public FORM<Hamlet> form() {
  return form_(this, false);
  }

  
  public FORM<Hamlet> form(String selector) {
    return setSelector(form(), selector);
  }

  
  public FIELDSET<Hamlet> fieldset() {
  return fieldset_(this, false);
  }

  
  public FIELDSET<Hamlet> fieldset(String selector) {
    return setSelector(fieldset(), selector);
  }

  
  public INS<Hamlet> ins() {
  return ins_(this, false);
  }

  
  public Hamlet ins(String cdata) {
    return ins()._(cdata)._();
  }

  
  public DEL<Hamlet> del() {
  return del_(this, false);
  }

  
  public Hamlet del(String cdata) {
    return del()._(cdata)._();
  }
}
