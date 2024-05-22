"use strict";(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[4873],{54873:function(e,t,r){r.d(t,{r:function(){return E},wV:function(){return S}});var n,i=r(39993),o=r(49292),a=r(89064),s=r(71023),l=r(50164),c=r(73602),d=r(35968),u=r(76603),m=r(17601),p=r(82517),h=r(56009),f=r(87648),g=r(29057),x=r(21218),v=r(19841),y=r(61888),b=r.n(y),j=r(73429),w=r.n(j),k=r(70079),N=r(84692),O=r(9063),P=r(68498),C=r(21389),T=r(9457),D=r(12882),L=r(35250);function U(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),r.push.apply(r,n)}return r}function _(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?U(Object(r),!0).forEach(function(t){(0,i.Z)(e,t,r[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):U(Object(r)).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))})}return e}let M=C.Z.div(n||(n=(0,o.Z)(["group flex h-10 items-center gap-2 rounded-lg px-2 font-medium hover:bg-token-main-surface-secondary text-sm text-token-text-primary"])));function E(){let{data:e,isLoading:t}=(0,c.Fi)({cutId:"recent",limit:8}),{data:r,isLoading:n}=(0,c.Dq)();return{isLoading:t||n,recent:e,pinned:r}}let A=(0,k.forwardRef)(function(e,t){let{query:r,onSelectGizmo:n,selectedIdx:i}=e,o=(0,f.oc)(),a=(0,k.useRef)([]),{isLoading:l,recent:c,pinned:d}=E();(0,k.useImperativeHandle)(t,()=>({handleEnterOnIndex:e=>{if(!p[e])return e<m.length?m[e].resource:"create"},getResultsLength:()=>m.length+1,scrollToItem:e=>{let t=a.current[e];t&&t.scrollIntoView({behavior:"instant",block:"nearest"})}}));let m=[];if(l)return(0,L.jsx)("div",{className:"flex h-full items-center justify-center",children:(0,L.jsx)(s.Z,{})});c&&m.push(...c.pages.flatMap(e=>e.list.items).map(e=>({resource:e.resource,from:"recent"}))),d&&m.push(...d.items.map(e=>({resource:e,from:"pinned"})));let p=(m=b().uniqBy(m,e=>e.resource.gizmo.id)).map(e=>{var t;return null===(t=e.resource.gizmo.tags)||void 0===t?void 0:t.includes(u.U9.WorkspaceDisabled)});return r&&""!==r&&(m=m.filter(e=>{var t,n;return(e.resource.gizmo.display.name.toLowerCase()+(null===(t=e.resource.gizmo.display.description)||void 0===t?void 0:t.toLowerCase())+(null===(n=e.resource.gizmo.author.display_name)||void 0===n?void 0:n.toLowerCase())).includes(null==r?void 0:r.toLowerCase())})),(0,L.jsxs)("div",{className:"max-h-40 overflow-y-auto",children:[m.map((e,t)=>(0,L.jsx)("div",{ref:e=>a.current[t]=e,tabIndex:t,onClick:()=>{p[t]||n(e.resource)},children:(0,L.jsx)(I,{gizmoResource:e.resource,from:e.from,showDescription:o,isSelected:i===t,grayedOut:p[t]})},e.resource.gizmo.id)),(0,L.jsx)("div",{ref:e=>a.current[m.length]=e,tabIndex:m.length,onClick:()=>{n("create")},children:(0,L.jsx)(R,{isSelected:i===m.length})},"create")]})}),R=e=>{let{isSelected:t}=e;return(0,L.jsx)(M,{className:t?"bg-token-main-surface-secondary":"",children:(0,L.jsxs)(w(),{href:"/gpts/editor",target:"_blank",className:"flex flex-row space-x-2",children:[(0,L.jsx)("span",{className:"self-center",children:(0,L.jsx)(T.Vz5,{className:"icon-sm"})}),(0,L.jsx)("span",{children:(0,L.jsx)(N.Z,_({},Z.dropdownCreateLabel))})]})})},z=e=>{let{onClick:t,onClose:r}=e,{0:n,1:i}=(0,k.useState)(null),o=(0,k.useRef)(null),a=(0,k.useRef)(null),{0:s,1:l}=(0,k.useState)(0),c=(0,O.Z)(),d=e=>{g.A.logEvent(x.M.mentionsClickGizmo,{gizmo_id:"create"===e?"create":e.gizmo.id}),"create"!==e&&t(e)};return(0,L.jsxs)(L.Fragment,{children:[(0,L.jsx)("input",{autoFocus:!0,placeholder:c.formatMessage(Z.searchPlaceholder),ref:o,onKeyDown:e=>{var t,i,o,c,u;let m=null!==(t=null===(i=a.current)||void 0===i?void 0:i.getResultsLength())&&void 0!==t?t:0;if("Escape"!==e.key&&("Backspace"!==e.key||n)||(e.preventDefault(),r()),"Enter"===e.key||"Tab"===e.key){e.preventDefault();let t=null===(o=a.current)||void 0===o?void 0:o.handleEnterOnIndex(s);if(!t)return;"create"===t?(window.open("/gpts/editor","_blank"),r()):d(t)}if("ArrowDown"===e.key&&s<m-1){e.preventDefault();let t=s+1;null===(c=a.current)||void 0===c||c.scrollToItem(t),l(t)}if("ArrowUp"===e.key&&s>0){e.preventDefault();let t=s-1;null===(u=a.current)||void 0===u||u.scrollToItem(t),l(t)}},onChange:e=>{i(e.target.value),l(0)},className:"mb-1 w-full border-0 bg-token-main-surface-primary p-2 text-sm focus:outline-none"}),(0,L.jsx)(A,{ref:a,query:n,selectedIdx:s,onSelectGizmo:d})]})};function I(e){var t;let{gizmoResource:r,from:n,showDescription:i,isSelected:o,grayedOut:a}=e,s=!!(null===(t=r.gizmo.tags)||void 0===t?void 0:t.includes(u.U9.FirstParty));return(0,L.jsxs)(M,{className:(0,v.default)(o?"bg-token-main-surface-secondary":"",a&&"opacity-50"),children:[(0,L.jsx)(l.Z,{isFirstParty:s,src:r.gizmo.display.profile_picture_url,className:(0,v.default)("icon-xl h-7 w-7 flex-shrink-0",a&&"grayscale group-hover:grayscale-0")}),(0,L.jsxs)("div",{className:"flex h-fit grow flex-row justify-between space-x-2 overflow-hidden text-ellipsis whitespace-nowrap",children:[(0,L.jsxs)("div",{className:"flex flex-row space-x-2",children:[(0,L.jsx)("span",{className:"shrink-0 truncate",children:r.gizmo.display.name}),i&&(0,L.jsx)("span",{className:"flex-grow truncate text-sm font-light text-token-text-tertiary sm:max-w-xs lg:max-w-md",children:r.gizmo.display.description})]}),(0,L.jsx)("span",{className:"shrink-0 self-center",children:"recent"===n?(0,L.jsx)(T.T39,{className:"icon-sm"}):(0,L.jsx)(T.qQX,{className:"icon-sm"})})]})]})}function S(e){var t;let{gizmoResource:r,onRemove:n}=e,i=!!(null===(t=r.gizmo.tags)||void 0===t?void 0:t.includes(u.U9.FirstParty));return(0,L.jsxs)("div",{className:"flex w-full flex-row items-center rounded-t-2xl bg-token-main-surface-secondary px-2 py-1",children:[(0,L.jsxs)("div",{className:(0,v.default)("group flex h-10 items-center gap-2 rounded-lg px-2 font-medium"),children:[(0,L.jsx)(l.Z,{isFirstParty:i,src:r.gizmo.display.profile_picture_url,className:"h-6 w-6 flex-shrink-0"}),(0,L.jsxs)("div",{className:"space-x-2 overflow-hidden text-ellipsis text-sm font-light text-token-text-tertiary",children:[(0,L.jsx)(N.Z,_({},Z.talkingTo))," ",(0,L.jsx)("span",{className:"font-medium text-token-text-secondary",children:r.gizmo.display.name})]})]}),n&&(0,L.jsx)("button",{className:"absolute right-4 text-sm font-bold",onClick:n,children:(0,L.jsx)(d.v7,{className:"icon-md text-token-text-secondary hover:text-token-text-primary"})})]})}let Z=(0,P.vU)({talkingTo:{id:"TaggingDropdown.talkingTo",defaultMessage:"Talking to"},dropdownCreateLabel:{id:"TaggingDropdown.dropdownCreateLabel",defaultMessage:"Create a GPT"},searchPlaceholder:{id:"TaggingDropdown.searchPlaceholder",defaultMessage:"Search recent and pinned GPTs"}});t.ZP=e=>{let{onClick:t,onClose:r}=e,n=(0,p.Ib)(),i=!!n&&(0,h.PX)(n);return((0,m.n)(()=>{g.A.logEvent(x.M.mentionsOpened,{gizmo_selector_disabled:i})}),i)?(0,L.jsx)(D.c,{rateLimitWithBannerDescription:n,clientThreadId:a.Zq}):(0,L.jsx)("div",{onBlur:e=>{e.currentTarget.contains(e.relatedTarget)||r()},className:"popover rounded-2xl border border-token-border-light bg-token-main-surface-primary p-2 shadow-lg",children:(0,L.jsx)(z,{onClick:t,onClose:r})})}},12882:function(e,t,r){r.d(t,{W:function(){return k},c:function(){return w}});var n=r(39993),i=r(89064),o=r(61008),a=r(9063),s=r(42596),l=r(35250);let c=e=>{var t,r,n,i,o,c;let{actions:d,text:u,onDismiss:m}=e,p=(0,a.Z)(),h=null!=d&&null!==(t=d.primaryAction)&&void 0!==t&&t.text?p.formatMessage(d.primaryAction.text):void 0,f=null!=d&&null!==(r=d.secondaryAction)&&void 0!==r&&r.text?p.formatMessage(d.secondaryAction.text):void 0;return(0,l.jsx)(s.j,{content:u,onDismiss:m,primaryCtaText:h,onPrimaryCtaClick:null!==(n=null==d||null===(i=d.primaryAction)||void 0===i?void 0:i.onClick)&&void 0!==n?n:void 0,secondaryCtaText:f,onSecondaryCtaClick:null!==(o=null==d||null===(c=d.secondaryAction)||void 0===c?void 0:c.onClick)&&void 0!==o?o:void 0,isElevated:!0})};var d=r(17601),u=r(93130),m=r(82517),p=r(56009),h=r(29057);r(70079);var f=r(84692),g=r(68498),x=r(12791),v=r(1306);function y(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),r.push.apply(r,n)}return r}function b(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?y(Object(r),!0).forEach(function(t){(0,n.Z)(e,t,r[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):y(Object(r)).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))})}return e}let j=e=>{let{clientThreadId:t,location:r,primaryAction:n,rateLimitWithBannerDescription:i,description:o,onDismiss:a}=e,s={primaryAction:n,secondaryAction:function(e){let{location:t,rateLimit:r,hasNoAvailableModels:n,updateModelQueryParam:i}=e;if(!n||!(0,p.Qh)(r))return null;let{limit_details:{next_model_slug:o}}=r;return{text:O.newChatButton,onClick:()=>{i({modelId:o,location:t})}}}({location:r,hasNoAvailableModels:(0,x.y)(t),updateModelQueryParam:(0,v.fm)(!0),rateLimit:i})};return(0,l.jsx)(c,{text:o,actions:s,onDismiss:a})},w=e=>{var t;let{clientThreadId:r,rateLimitWithBannerDescription:n,onDismiss:a}=e,s=(0,u.t)(),g=null!==(t=null==s?void 0:s.planType)&&void 0!==t?t:"unknown",x=(0,m.DJ)(r),{call_to_action:v,display_description:y}=n,w=y.type,k=y.description;x&&(k=function(e){let t=N(e.reason);return(0,l.jsx)(f.Z,b(b({},t),{},{values:{modelName:e.modelName,anotherModelName:e.modelName}}))}(x)),(0,d.n)(()=>{var e;h.A.logRateLimitBannerShown({location:w,type:null!==(e=(0,p.EJ)(n))&&void 0!==e?e:"unknown",plan_type:g})});let P=v?v===i.Pt.GET_PLUS?{text:O.getPlusButton,onClick:()=>{var e;h.A.logRateLimitGetPlusButtonClicked({type:null!==(e=(0,p.EJ)(n))&&void 0!==e?e:"unknown",location:w,plan_type:g}),(0,o.MG)()}}:void 0:null;return null!=r?(0,l.jsx)(j,{clientThreadId:r,location:w,description:k,onDismiss:x?void 0:a,primaryAction:P,rateLimitWithBannerDescription:n}):(0,l.jsx)(c,{text:k,actions:{primaryAction:P},onDismiss:a})},k=e=>{let{clientThreadId:t,rateLimitWithBannerDescription:r,onDismiss:n}=e;return(0,l.jsx)(w,{clientThreadId:t,rateLimitWithBannerDescription:r,onDismiss:n})},N=e=>{switch(e){case i.Lt.UNSUPPORTED_ATTACHMENT:return O.disabledChatRateLimitUnsupportedFileAttachments;case i.Lt.UNSUPPORTED_AUDIO:return O.disabledChatRateLimitUnsupportedAudio;case i.Lt.UNSUPPORTED_GIZMO:return O.disabledChatRateLimitUnsupportedGPT;case i.Lt.UNSUPPORTED_IMAGE:return O.disabledChatRateLimitUnsupportedImage;case i.Lt.UNSUPPORTED_TOOL_USE:return O.disabledChatRateLimitUnsupportedTool}},O=(0,g.vU)({getPlusButton:{id:"TeyLcp",defaultMessage:"Get Plus"},newChatButton:{id:"7OvnJ5",defaultMessage:"New chat"},disabledChatRateLimitUnsupportedFileAttachments:{id:"95Koqo",defaultMessage:"You've reached your {modelName} limit. You need {anotherModelName} to continue this chat because there's an attachment."},disabledChatRateLimitUnsupportedAudio:{id:"oNh4AV",defaultMessage:"You've reached your {modelName} limit. You need {anotherModelName} to continue this chat because it uses audio."},disabledChatRateLimitUnsupportedGPT:{id:"cfY1TO",defaultMessage:"You've reached your {modelName} limit. You need {anotherModelName} to continue this chat because this GPT requires it."},disabledChatRateLimitUnsupportedImage:{id:"c5wuen",defaultMessage:"You've reached your {modelName} limit. You need {anotherModelName} to continue this chat because it has images."},disabledChatRateLimitUnsupportedTool:{id:"bhPCfD",defaultMessage:"You've reached your {modelName} limit. You need {anotherModelName} to continue this chat because it uses tools."}})},17601:function(e,t,r){r.d(t,{n:function(){return i}});var n=r(70079);let i=e=>{(0,n.useEffect)(e,[])}}}]);
//# sourceMappingURL=4873-a86487e3113c6a60.js.map