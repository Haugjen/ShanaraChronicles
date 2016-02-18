uniform sampler2D m_ColorMap;
 
varying vec2 texCoord;
uniform vec4 m_Color;
 
void main(){  
 
   // vec4 color = texture2D(m_ColorMap, texCoord);
  //  gl_FragColor=color;
  
  //vec4 texColor = texture2D(m_ColorMap, texCoord);
   // gl_FragColor = vec4(mix(m_Color.rgb, texColor.rgb, texColor.a), 1.0);

   // vec4 texColor = texture2D(m_ColorMap, texCoord);
   // gl_FragColor = vec4(mix(m_Color.rgb, texColor.rgb, texColor.a), texColor.a);

    vec4 color = vec4(1.0);

    #ifdef HAS_COLORMAP
        color *= texture2D(m_ColorMap, texCoord);     
    #endif

    #ifdef HAS_VERTEXCOLOR
        color *= vertColor;
    #endif

    #ifdef HAS_COLOR
        color *= m_Color;
    #endif

    gl_FragColor = color;
}