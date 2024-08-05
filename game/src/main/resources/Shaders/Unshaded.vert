#import "Common/ShaderLib/GLSLCompat.glsllib"
#import "Common/ShaderLib/Instancing.glsllib"

attribute vec3 inPosition;
attribute vec3 inNormal;

varying vec3 normal;

uniform float u_ScaleFactor;

void main(){
    vec4 scaledPosition = vec4(inPosition * u_ScaleFactor, 1.0);
    gl_Position = TransformWorldViewProjection(scaledPosition);
    normal = inNormal;
}
