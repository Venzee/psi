function frameAutoSize(oIframe){
    try{
        var oWin = oIframe.name ? window.frames[oIframe.name] : oIframe.contentWindow; 
        oIframe.style.height = oWin.document.body.scrollHeight + "px";
        oIframe.style.width = oWin.document.body.width + "px";
    }catch(e){}
}
